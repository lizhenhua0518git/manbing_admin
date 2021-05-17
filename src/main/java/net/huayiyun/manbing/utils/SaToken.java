package net.huayiyun.manbing.utils;

import cn.dev33.satoken.stp.SaTokenInfo;
import cn.dev33.satoken.stp.StpUtil;

public class SaToken {

    public static void main(String[] args) {
        StpUtil.setLoginId("17611603396");

        SaTokenInfo saTokenInfo = StpUtil.getTokenInfo();

        System.out.println("用户信息 = " + saTokenInfo.toString());
    }

}
