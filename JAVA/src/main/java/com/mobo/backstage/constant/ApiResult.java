package com.mobo.backstage.constant;


/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 10:00
 * @Description:
 */
public class ApiResult<T> {

    private int status=ResultCode.SUCCESS_CODE;
    private String msg;
    private T data;

    public ApiResult(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public ApiResult() {
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
