package net.huayiyun.manbing.common.domain;

import io.swagger.annotations.ApiModel;
import net.huayiyun.manbing.common.constant.Constants;

import java.io.Serializable;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.common.domain
 * @Description : TODO
 * @Author : wyb
 * @Creation Date : 2021年04月19日 17:48
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@ApiModel(value = "消息体")
public class ResultEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    /** 成功 */
    public static final int SUCCESS = Constants.SUCCESS;

    /** 成功 */
    public static final String SUCCESS_MSG = "成功";

    /** 失败 */
    public static final int FAIL = Constants.FAIL;

    private int code;

    private String msg;

    private T data;

    public static <T> ResultEntity<T> ok()
    {
        return restResult(null, SUCCESS, SUCCESS_MSG);
    }

    public static <T> ResultEntity<T> ok(T data)
    {
        return restResult(data, SUCCESS, SUCCESS_MSG);
    }

    public static <T> ResultEntity<T> ok(T data, String msg)
    {
        return restResult(data, SUCCESS, msg);
    }

    public static <T> ResultEntity<T> fail()
    {
        return restResult(null, FAIL, null);
    }

    public static <T> ResultEntity<T> fail(String msg)
    {
        return restResult(null, FAIL, msg);
    }

    public static <T> ResultEntity<T> fail(T data)
    {
        return restResult(data, FAIL, null);
    }

    public static <T> ResultEntity<T> fail(T data, String msg)
    {
        return restResult(data, FAIL, msg);
    }

    public static <T> ResultEntity<T> fail(int code, String msg)
    {
        return restResult(null, code, msg);
    }

    private static <T> ResultEntity<T> restResult(T data, int code, String msg)
    {
        ResultEntity<T> apiResult = new ResultEntity<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);
        return apiResult;
    }

    public int getCode()
    {
        return code;
    }

    public void setCode(int code)
    {
        this.code = code;
    }

    public String getMsg()
    {
        return msg;
    }

    public void setMsg(String msg)
    {
        this.msg = msg;
    }

    public T getData()
    {
        return data;
    }

    public void setData(T data)
    {
        this.data = data;
    }

}
