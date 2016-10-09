package com.jobscheduler.dashboard.utils;

/**
 * Created by wuhuachuan on 16/3/3.
 */
public enum ReturnStatusCode {

    SUCCESS(0);  //代表成功的请求

    private int code;

    ReturnStatusCode(final int code){this.code = code;}

    public int getCode(){
        return this.code;
    }
}
