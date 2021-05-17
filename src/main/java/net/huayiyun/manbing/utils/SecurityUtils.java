package net.huayiyun.manbing.utils;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import org.apache.shiro.util.ByteSource;
import net.huayiyun.manbing.common.constant.CacheConstants;
import org.apache.shiro.crypto.hash.Md5Hash;

import javax.servlet.http.HttpServletRequest;



public class SecurityUtils {


    /**
     * 根据request获取请求token
     */
    public static String getToken(HttpServletRequest request)
    {
        String token = ServletUtils.getRequest().getHeader(CacheConstants.HEADER);
        if (StringUtils.isNotEmpty(token) && token.startsWith(CacheConstants.TOKEN_PREFIX))
        {
            token = token.replace(CacheConstants.TOKEN_PREFIX, "");
        }
        return token;
    }

    public static String getMd5HashPassword(String password,String salt,Integer number){

        if(ObjectUtils.isEmpty(number)){
            number=199;
        }
        //盐值：取用户信息中唯一的字段来生成盐值，避免由于两个用户原始密码相同，加密后的密码也相同
        ByteSource random = ByteSource.Util.bytes(salt);
        //将原始密码加盐（上面生成的盐），并且用md5算法加密三次，将最后结果存入数据库中
        String result = new Md5Hash(password,random,number).toString();
        return result;
    }

    /**
     * 获取用户ID
     * @return
     */
    public static String getUserId(){
        return StpUtil.getLoginId().toString();
    }

    public static void main(String[] args) {
        String result = "123456";
        for (int i = 1; i < 99; i++) {
            result = String.valueOf(new Md5Hash(result));
        }
        System.out.println("99次 = " + result);
        //9fe29eac58df33afb235abff848ea1f0
        String result1 = SecurityUtils.getMd5HashPassword("123456","1081765618e94424eb5641c1dbcf02cd",199);
        System.out.println("199次加盐 = " + result1);
        // a70d7ff5ef425b948770bc0cf6ae3934
    }
}
