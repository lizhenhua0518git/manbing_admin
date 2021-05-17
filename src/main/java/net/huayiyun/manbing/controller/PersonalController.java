package net.huayiyun.manbing.controller;

import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import net.huayiyun.manbing.annotation.ApiVersion;
import net.huayiyun.manbing.common.domain.ResultEntity;
import net.huayiyun.manbing.common.enums.ResultCodeEnum;
import net.huayiyun.manbing.exception.CaptchaException;
import net.huayiyun.manbing.pojo.qo.AuthStaffQO;
import net.huayiyun.manbing.pojo.qo.LoginQO;
import net.huayiyun.manbing.pojo.vo.AuthStaffVO;
import net.huayiyun.manbing.pojo.vo.LoginVO;
import net.huayiyun.manbing.service.AuthStaffService;
import net.huayiyun.manbing.service.LoginService;
import net.huayiyun.manbing.service.TokenService;
import net.huayiyun.manbing.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Api(value = "个人中心")
@RestController
@RequestMapping("{version}/personal")
@Slf4j
public class PersonalController {


    @Autowired
    TokenService tokenService;

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    AuthStaffService authStaffService;

    /**
     *
     * @param authStaffQO
     * @return
     */
    @ApiVersion(1)
    @PostMapping("updateInfo")
    public ResultEntity<LoginVO> pclogin(@RequestBody AuthStaffQO authStaffQO) {
        log.info("个人中心，参数：{}", authStaffQO.toString());
        authStaffService.update(authStaffQO);
        return ResultEntity.ok();
    }

}
