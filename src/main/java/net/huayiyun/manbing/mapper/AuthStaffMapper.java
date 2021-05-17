package net.huayiyun.manbing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import net.huayiyun.manbing.pojo.po.AuthStaff;
import net.huayiyun.manbing.pojo.qo.StaffPageQO;

import java.util.List;
import java.util.Map;

public interface AuthStaffMapper extends BaseMapper<AuthStaff> {

    List getPage(Map<String, StaffPageQO> map);
}
