package com.sdrc.onlinedrawing.util;

public class InfoUtils {
    private Boolean aBoolean;
    private Object object;
    private String Message;

    public InfoUtils() {
    }

    public InfoUtils(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public InfoUtils(Object object) {
        this.object = object;
    }

    public InfoUtils(String message) {
        Message = message;
    }

    public Boolean getaBoolean() {
        return aBoolean;
    }

    public void setaBoolean(Boolean aBoolean) {
        this.aBoolean = aBoolean;
    }

    public Object getObject() {
        return object;
    }

    public void setObject(Object object) {
        this.object = object;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String message) {
        Message = message;
    }

    public InfoUtils(Boolean aBoolean, Object object, String message) {
        this.aBoolean = aBoolean;
        this.object = object;
        Message = message;
    }
}
