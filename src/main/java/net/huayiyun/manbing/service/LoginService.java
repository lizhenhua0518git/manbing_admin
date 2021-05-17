package net.huayiyun.manbing.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import net.huayiyun.manbing.common.constant.UserConstants;
import net.huayiyun.manbing.common.enums.ResultCodeEnum;
import net.huayiyun.manbing.common.enums.UserStatus;
import net.huayiyun.manbing.exception.CaptchaException;
import net.huayiyun.manbing.exception.CustomException;
import net.huayiyun.manbing.mapper.AuthStaffMapper;
import net.huayiyun.manbing.pojo.po.AuthStaff;
import net.huayiyun.manbing.pojo.qo.LoginQO;
import net.huayiyun.manbing.pojo.vo.LoginVO;
import net.huayiyun.manbing.utils.SecurityUtils;
import net.huayiyun.manbing.utils.StringUtils;
import net.huayiyun.manbing.utils.bean.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class LoginService {

    @Autowired
    AuthStaffMapper authStaffMapper;



    public LoginVO authentication(LoginQO loginQo, HttpSession session) {
        LoginVO loginVO = new LoginVO();

        //从session中获取随机数
        String inputStr = loginQo.getCaptcha();

        String random = (String) session.getAttribute("RANDOMVALIDATECODEKEY");

        if (random == null || "".equals(random) || !random.equalsIgnoreCase(inputStr)) {
            throw new CaptchaException("验证码错误",ResultCodeEnum.ERROR_VALIDATION.getCode());
        }
        // 用户名或密码为空 错误
        if (StringUtils.isAnyBlank(loginQo.getStaffAccount(), loginQo.getStaffPassword())) {
            throw new CustomException("用户/密码必须填写！", ResultCodeEnum.ERROR_PARAM.getCode());
        }
        // 用户名不在指定范围内 错误
        if (loginQo.getStaffAccount().length() < UserConstants.USERNAME_MIN_LENGTH
                || loginQo.getStaffAccount().length() > UserConstants.USERNAME_MAX_LENGTH) {
            throw new CustomException("用户名不在指定范围！", ResultCodeEnum.ERROR_PARAM.getCode());
        }

        LambdaQueryWrapper<AuthStaff> wrapper = new LambdaQueryWrapper();
        //第一个参数是字段的名称 ， 第二个参数是设置的值
        wrapper.eq(AuthStaff::getStaffAccount, loginQo.getStaffAccount());
        // 查询用户信息
        AuthStaff authStaff = authStaffMapper.selectOne(wrapper);

        if (StringUtils.isNull(authStaff)) {
            throw new CustomException("该账号不存在！", ResultCodeEnum.SUCCESS_DATA_NULL.getCode());
        }

        if (!SecurityUtils.getMd5HashPassword(loginQo.getStaffPassword(), authStaff.getStaffId(), 199).equals(authStaff.getStaffPassword())) {
            throw new CustomException("密码错误！", ResultCodeEnum.ERROR_VALIDATION.getCode());
        }

        if (authStaff.getStaffStatus().equals(UserStatus.DISABLE.getCode())) {
            throw new CustomException("该账号已停用！", ResultCodeEnum.ACCOUNT_DISABLED.getCode());
        }
        BeanUtils.copyProperties(authStaff, loginVO);
        return loginVO;
    }
}
