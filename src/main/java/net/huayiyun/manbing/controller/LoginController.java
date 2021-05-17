package net.huayiyun.manbing.controller;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.huayiyun.manbing.annotation.ApiVersion;
import net.huayiyun.manbing.common.constant.CacheConstants;
import net.huayiyun.manbing.common.domain.AjaxResult;
import net.huayiyun.manbing.common.domain.ResultEntity;
import net.huayiyun.manbing.common.enums.ResultCodeEnum;
import net.huayiyun.manbing.exception.CaptchaException;
import net.huayiyun.manbing.pojo.qo.LoginQO;
import net.huayiyun.manbing.pojo.vo.LoginVO;
import net.huayiyun.manbing.service.LoginService;
import net.huayiyun.manbing.service.TokenService;
import net.huayiyun.manbing.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Api(value = "登录")
@RestController
@RequestMapping("{version}/login")
@Slf4j
public class LoginController {

    @Autowired
    LoginService loginService;

    @Autowired
    TokenService tokenService;

    @Autowired
    RedisTemplate redisTemplate;

    @ApiVersion(1)
    @PostMapping("pclogin")
    public ResultEntity<LoginVO> pclogin(@RequestBody LoginQO loginQo,HttpSession session) {
        log.info("调用登录接口，参数：{}", loginQo.toString());
        LoginVO loginVo = loginService.authentication(loginQo,session);
        return ResultEntity.ok(tokenService.createToken(loginVo));
    }

//    @ApiVersion(1)
//    @PostMapping("getCache")
//    public Object Cache(String cache ) {
//        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
//        return redisTemplate.opsForValue().get(CacheConstants.LOGIN_TOKEN_KEY+saTokenInfo.getTokenValue());
//    }

    /**
     * 生成验证码
     */
    @ApiVersion(1)
    @RequestMapping(value = "/captcha")
    public void getVerify(HttpServletRequest request, HttpServletResponse response) {

        try {
            //设置相应类型,告诉浏览器输出的内容为图片
            response.setContentType("image/jpeg");
            //设置响应头信息，告诉浏览器不要缓存此内容
            response.setHeader("Pragma", "No-cache");
            response.setHeader("Cache-Control", "no-cache");
            response.setDateHeader("Expire", 0);
            CaptchaUtil randomValidateCode = new CaptchaUtil();
            randomValidateCode.getRandomCode(request, response);//输出验证码图片方法
        } catch (Exception e) {
            log.error("获取验证码失败>>>>  {} ", e);
            throw new CaptchaException("获取验证码失败", ResultCodeEnum.ERROR_VALIDATION.getCode());
        }
    }

}
