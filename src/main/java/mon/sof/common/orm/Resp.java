package mon.sof.common.orm;

import cn.hutool.http.HttpStatus;
import cn.hutool.json.JSONUtil;
import mon.sof.common.tool.Constant;

public class Resp<T> {
    private int code;
    private String msg;
    private T data;

    public static Resp ok() {
        return new Resp(HttpStatus.HTTP_OK, "ok", null);
    }

    public static Resp ok(String msg, Object data) {
        return new Resp(HttpStatus.HTTP_OK, msg, data);
    }

    public static Resp ok(Object data) {
        return new Resp(HttpStatus.HTTP_OK, "ok", data);
    }

    public static Resp err(String msg) {
        return new Resp(Constant.REQ_ERR, msg, null);
    }

    public static Resp err(String msg, Object data) {
        return new Resp(Constant.REQ_ERR, msg, data);
    }

    public static Resp err(int code, String msg) {
        return err(code, msg, null);
    }

    public static Resp err(int code, String msg, Object data) {
        return new Resp(code, msg, data);
    }

    public Resp() {
    }

    public Resp(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return JSONUtil.toJsonPrettyStr(this);
    }
}
