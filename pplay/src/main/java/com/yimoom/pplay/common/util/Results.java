package com.yimoom.pplay.common.util;

import com.yimoom.pplay.common.base.entity.Result;

/**
 * Result生成工具类
 *
 * @version 1.0
 * @author jiangchenghua 2018-10-24
 */
public class Results {

    protected Results() {}

    public static Result newResult() {
        return new Result();

    }

    public static Result newResult(boolean success) {
        return new Result(success);
    }

    //
    // 业务调用成功
    // ----------------------------------------------------------------------------------------------------
    public static Result success() {
        return new Result();
    }

    public static Result success(String msg) {
        return new Result(true, null, msg);
    }

    public static Result success(String code, String msg) {
        return new Result(true, code, msg);
    }

    public static Result successWithStatus(Integer status) {
        return new Result(true, status);
    }

    public static Result successWithStatus(Integer status, String msg) {
        return new Result(true, status, null, msg);
    }

   
   

    //
    // 业务调用失败
    // ----------------------------------------------------------------------------------------------------
    public static Result failure() {
        return new Result(false);
    }

    public static Result failure(String msg) {
        return new Result(false, null, msg);
    }

    public static Result failure(String code, String msg) {
        return new Result(false, code, msg);
    }

    public static Result failureWithStatus(Integer status) {
        return new Result(false, status);
    }

    public static Result failureWithStatus(Integer status, String msg) {
        return new Result(false, status, null, msg);
    }

   

}
