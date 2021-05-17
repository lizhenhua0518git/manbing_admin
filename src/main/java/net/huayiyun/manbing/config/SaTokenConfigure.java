package net.huayiyun.manbing.config;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.router.SaRouterUtil;
import cn.dev33.satoken.stp.StpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Arrays;

@Configuration
public class SaTokenConfigure implements WebMvcConfigurer {

    private static final Logger log = LoggerFactory.getLogger(SaTokenConfigure.class);

    // 注册sa-token的拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // 注册路由拦截器，自定义验证规则
        registry.addInterceptor(new SaRouteInterceptor((request, response, handler) -> {
            //log.info("请求路径：{}",registry.);
            log.info("请求地址：{}", request.getRequestPath());
            // 登录验证 -- 排除多个路径
            SaRouterUtil.match(Arrays.asList("/**"), Arrays.asList("/v1/login/pclogin", "/doc.html/**", "/webjars/**", "/v1/file/**"), () -> StpUtil.checkLogin());

        })).addPathPatterns("/**").excludePathPatterns("/swagger-resources/**", "/webjars/**", "/v2/**", "/swagger-ui.html/**"
                , "/doc.html/**", "/error", "/favicon.ico", "/v1/file/**");
    }

    /**
     * 跨域配置
     *
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOriginPatterns("*")
                .allowedMethods("GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS")
                .allowCredentials(true)
                .maxAge(3600)
                .allowedHeaders("*");
    }
}
