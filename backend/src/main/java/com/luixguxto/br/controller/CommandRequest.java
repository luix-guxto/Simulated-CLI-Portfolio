package com.luixguxto.br.controller;

import jakarta.validation.constraints.NotBlank;

public class CommandRequest {

    @NotBlank
    private String cmd;
    private String[] args;
    private String lang = "pt";

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String[] getArgs() {
        return args;
    }

    public void setArgs(String[] args) {
        this.args = args;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }
}
