package com.bw.movie.bean;

/**
 * Created by 1607c王晴
 * date 2019/3/12
 * Describe:
 */
public class Result<T> {

    private String message;
    private String status;
    private Object[] args;
    private T result;

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
