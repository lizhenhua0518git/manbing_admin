package net.huayiyun.manbing.until;


import lombok.Data;
import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author wyb
 * @Description //TODO 版本控制
 * @Date 2021/4/18 21:18
 * @Param
 * @return
 **/
@Data
public class ApiVersionRequestCondition implements RequestCondition<ApiVersionRequestCondition> {

    // 用于匹配request中的版本号  v1 v2
    private static final Pattern VERSION_PREFIX = Pattern.compile("/v(\\d+).*");
    // 保存当前的版本号
    private int apiVersion;
    // 保存所有接口的最大版本号
    private static int maxVersion = 1;

    public ApiVersionRequestCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }
    /**
     * 最近优先原则，方法定义的 @ApiVersion > 类定义的 @ApiVersion
     */
    @Override
    public ApiVersionRequestCondition combine(ApiVersionRequestCondition other) {
        return new ApiVersionRequestCondition(other.getApiVersion());
    }
    /**
     * 获得符合匹配条件的ApiVersionCondition
     */
    @Override
    public ApiVersionRequestCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX.matcher(request.getRequestURI());
        if (m.find()) {
            int version = Integer.parseInt(m.group(1));
            if (version >= getApiVersion()) {
                return this;
            }
        }
        return null;
    }
    /**
     * 当出现多个符合匹配条件的ApiVersionCondition，优先匹配版本号较大的
     */
    @Override
    public int compareTo(ApiVersionRequestCondition other, HttpServletRequest request) {
        return other.getApiVersion() - getApiVersion();
    }
}
