package com.luixguxto.br.util;

public class Response {

    public static String getResponse(String message, int status){
        message = message.replace("\"", "'");
        return "{ \"message\": \"" + message + "\", \"status\": " + status + " }";
    }

    public static String getResponseData(String message, int status){
        return "{ \"message\": " + message + ", \"status\": " + status + " }";
    }
}
