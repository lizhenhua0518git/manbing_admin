package net.huayiyun.manbing.service;

import cn.dev33.satoken.SaManager;
import cn.dev33.satoken.config.SaTokenConfig;
import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;
import net.huayiyun.manbing.common.constant.CacheConstants;
import net.huayiyun.manbing.pojo.vo.LoginVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @Project : manbing
 * @Package Name : net.huayiyun.manbing.service
 * @Description : TODO
 * @Author : wyb
 * @Creation Date : 2021年04月19日 14:16
 * @ModificationHistory Who        When           What
 * -------------- -------------- ---------------------
 */
@Component
public class TokenService {

    @Autowired
    private RedisService redisService;

    private final static String ACCESS_TOKEN = CacheConstants.LOGIN_TOKEN_KEY;

    /**
     * 创建令牌
     */
    public LoginVO createToken(LoginVO loginVO) {
        // 生成token
        StpUtil.setLoginId(loginVO.getStaffId());
        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
        loginVO.setToken(saTokenInfo.tokenValue);
        SaTokenConfig saTokenConfig = SaManager.getConfig();
//        redisService.setCacheObject(ACCESS_TOKEN + saTokenInfo.tokenValue, loginVO, saTokenConfig.getTimeout(), TimeUnit.SECONDS);
        return loginVO;
    }

    /**
     * 更新缓存的用户信息
     *
     * @param authStaffVO
     */
//    public void updateUserInfo(AuthStaffVO authStaffVO) {
//        if (StringUtils.isNotNull(authStaffVO)) {
//            SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();
//            SaTokenConfig saTokenConfig = SaManager.getConfig();
//            redisService.setCacheObject(ACCESS_TOKEN + saTokenInfo.tokenValue, authStaffVO, saTokenConfig.getTimeout(), TimeUnit.SECONDS);
//        }
//    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
//    public AuthStaffVO getLoginUser() {
//        return getLoginUser(ServletUtils.getRequest());
//    }

    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
/*    public AuthStaffVO getLoginUser(HttpServletRequest request) {
        // 获取请求携带的令牌
        //String token = SecurityUtils.getToken(request);
        String token = StpUtil.getTokenValue();
        if (StringUtils.isNotEmpty(token)) {
            String userKey = getTokenKey(token);
            AuthStaffVO user = redisService.getCacheObject(userKey);
            return user;
        }
        return null;
    }*/


   /* public void delLoginUser() {
        String userKey = getTokenKey(StpUtil.getTokenValue());
        redisService.deleteObject(userKey);
    }

    public void delLoginUser(String token) {
        String userKey = getTokenKey(token);
        redisService.deleteObject(userKey);
    }


    private String getTokenKey(String token) {
        return ACCESS_TOKEN + token;
    }*/


}
