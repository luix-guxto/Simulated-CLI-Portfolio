import os
import time
import threading
from http.server import SimpleHTTPRequestHandler, HTTPServer

WATCHED_EXTENSIONS = [".html", ".css", ".js", ".json", ".md"]  # extensões que você quer monitorar

class NoCacheHandler(SimpleHTTPRequestHandler):
    def end_headers(self):
        self.send_header("Cache-Control", "no-store, no-cache, must-revalidate, max-age=0")
        self.send_header("Pragma", "no-cache")
        self.send_header("Expires", "0")
        super().end_headers()

def list_all_files(root=".", extensions=None):
    files = []
    for dirpath, _, filenames in os.walk(root):
        for filename in filenames:
            if extensions:
                if not any(filename.endswith(ext) for ext in extensions):
                    continue
            full_path = os.path.join(dirpath, filename)
            files.append(full_path)
    return files

def monitor_changes(root, stop_callback, interval=1):
    print("[Monitor] Iniciando monitoramento recursivo...")
    tracked_files = list_all_files(root, WATCHED_EXTENSIONS)
    last_mtimes = {file: os.path.getmtime(file) for file in tracked_files}

    while True:
        time.sleep(interval)
        current_files = list_all_files(root, WATCHED_EXTENSIONS)
        for file in current_files:
            try:
                current_mtime = os.path.getmtime(file)
                if file not in last_mtimes or current_mtime != last_mtimes[file]:
                    print(f"[Monitor] Alteração detectada em: {file}")
                    stop_callback()
                    return
                last_mtimes[file] = current_mtime
            except FileNotFoundError:
                continue

def stop_server(server):
    print("[Servidor] Parando o servidor devido a alteração em arquivo...")
    threading.Thread(target=server.shutdown).start()
    exit(0)

if __name__ == '__main__':
    PORT = 8000
    httpd = HTTPServer(('', PORT), NoCacheHandler)
    print(f"[Servidor] Rodando em http://localhost:{PORT}")

    watcher_thread = threading.Thread(
        target=monitor_changes,
        args=(".", lambda: stop_server(httpd)),
        daemon=True
    )
    watcher_thread.start()

    try:
        httpd.serve_forever()
    except KeyboardInterrupt:
        print("[Servidor] Encerrado manualmente.")
