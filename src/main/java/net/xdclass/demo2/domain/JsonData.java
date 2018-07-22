package net.xdclass.demo2.domain;

import java.io.Serializable;

public class JsonData implements Serializable {
    //状态码 0表示成功 -1表示失败
    private int code;

    private Object data;
    private String msg;


    public static Object buildSuccess(int id) {
        return new JsonData(1, "success", "id="+id);
    }

    public static JsonData buildSuccess() {
        return new JsonData(1, "success", null);
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public JsonData(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public JsonData(int code, Object data) {
        this.code = code;
        this.data = data;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public JsonData(int code, Object data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
