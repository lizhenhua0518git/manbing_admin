package net.huayiyun.manbing.handler;

import cn.dev33.satoken.exception.NotLoginException;
import net.huayiyun.manbing.common.enums.ResultCodeEnum;
import net.huayiyun.manbing.common.domain.AjaxResult;
import net.huayiyun.manbing.exception.BaseException;
import net.huayiyun.manbing.exception.CaptchaException;
import net.huayiyun.manbing.exception.CustomException;
import net.huayiyun.manbing.exception.PreAuthorizeException;
import net.huayiyun.manbing.utils.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.handler
 * @Description : TODO 全局异常处理器
 * @Author : wyb
 * @Creation Date : 2021年04月19日 13:42
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 基础异常
     */
    @ExceptionHandler(BaseException.class)
    public AjaxResult baseException(BaseException e) {
        return AjaxResult.error(e.getDefaultMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(CustomException.class)
    public AjaxResult businessException(CustomException e) {
        if (StringUtils.isNull(e.getCode())) {
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.error(e.getCode(), e.getMessage());
    }

    /**
     * 业务异常
     */
    @ExceptionHandler(CaptchaException.class)
    public AjaxResult captchaException(CaptchaException e) {
        if (StringUtils.isNull(e.getCode())) {
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.error(e.getCode(), e.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public AjaxResult handleException(Exception e) {
        log.error(e.getMessage(), e);
        return AjaxResult.error(ResultCodeEnum.FAIL_SERVICE.getCode(), ResultCodeEnum.FAIL_SERVICE.getContext());
    }

    /**
     * 重复数据
     */
    @ExceptionHandler(DuplicateKeyException.class)
    public AjaxResult handleDuplicateKeyException(DuplicateKeyException e){
        log.error(e.getMessage(), e);
        return AjaxResult.error(ResultCodeEnum.SUCCESS_DATA_EXIST.getCode(), ResultCodeEnum.SUCCESS_DATA_EXIST.getContext());
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(BindException.class)
    public AjaxResult validatedBindException(BindException e) {
        log.error(e.getMessage(), e);
        String message = e.getAllErrors().get(0).getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 自定义验证异常
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Object validExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        String message = e.getBindingResult().getFieldError().getDefaultMessage();
        return AjaxResult.error(message);
    }

    /**
     * 权限异常
     */
    @ExceptionHandler(PreAuthorizeException.class)
    public AjaxResult preAuthorizeException(PreAuthorizeException e) {
        log.error("没有权限！");
        return AjaxResult.error(ResultCodeEnum.ERROR_AUTHORIZATION.getCode(), "没有权限，请联系管理员授权");
    }

    // 全局异常拦截（拦截项目中的NotLoginException异常）
    @ExceptionHandler(NotLoginException.class)
    public AjaxResult handlerNotLoginException(NotLoginException nle, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // 打印堆栈，以供调试
        //nle.printStackTrace();
        if (nle.getType().equals(NotLoginException.NOT_TOKEN)) {
            log.error("Token为空！");
            return AjaxResult.error(ResultCodeEnum.ERROR_AUTHENTICATION.getCode(), "Token为空！");
        } else if (nle.getType().equals(NotLoginException.INVALID_TOKEN)) {
            //message = "token无效";
            log.error("Token无效！");
            return AjaxResult.error(ResultCodeEnum.ERROR_AUTHENTICATION.getCode(), "未登录！");
        } else if (nle.getType().equals(NotLoginException.TOKEN_TIMEOUT)) {
            log.error("Token已过期！");
            return AjaxResult.error(ResultCodeEnum.ERROR_EXPIRED_TOKEN.getCode(), "Token已过期！");
        } else if (nle.getType().equals(NotLoginException.BE_REPLACED)) {
            log.error("账号已被顶下线！");
            return AjaxResult.error(ResultCodeEnum.ACCOUNT_PUSHER_DOWN.getCode(), "账号已被顶下线！");
        } else if (nle.getType().equals(NotLoginException.KICK_OUT)) {
            log.error("账号已被踢下线！");
            return AjaxResult.error(ResultCodeEnum.ACCOUNT_SPURN_DOWN.getCode(), "账号已被踢下线！");
        }
        log.error("未登录！");
        return AjaxResult.error(ResultCodeEnum.ERROR_AUTHENTICATION.getCode(), "未登录！");
    }


}
