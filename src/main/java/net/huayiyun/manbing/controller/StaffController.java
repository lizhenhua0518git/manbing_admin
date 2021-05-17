package net.huayiyun.manbing.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import lombok.extern.slf4j.Slf4j;
import net.huayiyun.manbing.annotation.ApiVersion;
import net.huayiyun.manbing.common.domain.ResultEntity;
import net.huayiyun.manbing.pojo.qo.StaffPageQO;
import net.huayiyun.manbing.pojo.qo.authStaff.AddAuthStaffQO;
import net.huayiyun.manbing.pojo.qo.authStaff.UpdataAuthStaffQO;
import net.huayiyun.manbing.service.AuthStaffService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/{version}/doc")
@Slf4j(topic = "StaffController")
public class StaffController {

    @Autowired
    private AuthStaffService authStaffService;

    @ApiVersion(1)
    @PostMapping("listDocs")
    public IPage listDocs(@RequestBody StaffPageQO staffPageQo) {
        return authStaffService.getPage(staffPageQo);
    }

    @ApiVersion(1)
    @PostMapping("addDoc")
    public ResultEntity addDoc(@RequestBody AddAuthStaffQO addAuthStaffQO){
        return ResultEntity.ok(authStaffService.addDoc(addAuthStaffQO));
    }

    @ApiVersion(1)
    @PostMapping("modifyDoc")
    public ResultEntity modifyDoc(@RequestBody UpdataAuthStaffQO updataAuthStaffQO){
        authStaffService.modifyDoc(updataAuthStaffQO);
        return ResultEntity.ok();
    }

    @ApiVersion(1)
    @PostMapping("modifyDocStatusById")
    public ResultEntity modifyDocStatusById(@RequestBody Map map){
        authStaffService.modifyDocStatusById(map);
        return ResultEntity.ok();
    }

}
