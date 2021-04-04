package edu.tyut.wrx.brain.model;

/**
 * 结果包装类
 */
public class ResultVO<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultVO() {
    }

    /**
     * 内部使用用于构造响应结果
     * @param code
     * @param msg
     */
    private ResultVO(Integer code,String msg){
        this.code = code;
        this.msg = msg;
    }

    /**
     * 内部使用用于构造响应结果
     * @param code
     * @param msg
     * @param data
     */
    private ResultVO(Integer code,String msg,T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    /**
     * 默认成功结果
     * @return
     */
    public static <E> ResultVO<E> success() {
        return new ResultVO<E>(ResultCode.SUCCESSFUL_CODE, ResultCode.SUCCESSFUL_MSG);
    }

    /**
     *成功结果
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ResultVO<E> success(E data) {
        return new ResultVO<E>(ResultCode.SUCCESSFUL_CODE, ResultCode.SUCCESSFUL_MSG,data);
    }

    /**
     * 默认失败结果
     * @param <E>
     * @return
     */
    public static <E> ResultVO<E> fail() {
        return new ResultVO<E>(ResultCode.FAILD_CODE, ResultCode.FAILD_MSG);
    }

    /**
     * 失败带错误提示
     * @param failMsg
     * @param <E>
     * @return
     */
    public static <E> ResultVO<E> fail(String failMsg) {
        ResultVO<E> resultVO = new ResultVO<>(ResultCode.FAILD_CODE, ResultCode.FAILD_MSG);
        resultVO.setMsg(failMsg);
        return resultVO;
    }

    /**
     * 失败带错误提示自定义
     * @param code
     * @param msg
     * @param <E>
     * @return
     */
    public static <E> ResultVO<E> fail(Integer code,String msg) {
        ResultVO<E> resultVO = new ResultVO(code,msg);
        return resultVO;
    }

    /**
     * 失败带错误数据
     * @param data
     * @param <E>
     * @return
     */
    public static <E> ResultVO<E> fail(E data) {
        ResultVO<E> resultVO = new ResultVO<>(ResultCode.FAILD_CODE, ResultCode.FAILD_MSG,data);
        return resultVO;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
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

    @Override
    public String toString() {
        return "ResultVO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
