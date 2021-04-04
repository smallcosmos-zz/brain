package edu.tyut.wrx.brain.model;

/**
 * 返回结果常量定义
 */
public class ResultCode {
    public static final int SUCCESSFUL_CODE = 200;
    public static final int FAILD_CODE = 300;
    public static final int EXCEPTION_CODE = 500;
    public static final int VALIDATION_FAILD_CODE = 4001;

    public static final String SUCCESSFUL_MSG = "处理成功";
    public static final String FAILD_MSG = "操作失败,请稍后重试";
    public static final String EXCEPTION_MSG = "处理出错";
    public static final String VALIDATION_FAILD_MSG = "校验出错";
}
