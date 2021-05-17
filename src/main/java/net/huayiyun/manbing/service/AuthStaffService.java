package net.huayiyun.manbing.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import net.huayiyun.manbing.mapper.AuthStaffMapper;
import net.huayiyun.manbing.pojo.po.AuthStaff;
import net.huayiyun.manbing.pojo.qo.AuthStaffQO;
import net.huayiyun.manbing.pojo.qo.StaffPageQO;
import net.huayiyun.manbing.pojo.qo.authStaff.AddAuthStaffQO;
import net.huayiyun.manbing.pojo.qo.authStaff.UpdataAuthStaffQO;
import net.huayiyun.manbing.pojo.vo.AuthStaffVO;
import net.huayiyun.manbing.utils.IdUtils;
import net.huayiyun.manbing.utils.SecurityUtils;
import net.huayiyun.manbing.utils.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Map;

@Service
public class AuthStaffService {

    @Autowired
    private AuthStaffMapper authStaffMapper;

    public IPage getPage(StaffPageQO staffPageQo) {
        Map map = new HashMap<>();
        Page page = new Page(staffPageQo.getPageNo(), staffPageQo.getPageSize());
        map.put("page", page);
        map.put("staffPageQo", staffPageQo);
        return page.setRecords(authStaffMapper.getPage(map));
    }

    /**
     * 修改个人信息
     */
    public AuthStaffVO update(AuthStaffQO authStaffQO) {
        AuthStaff authStaff = new AuthStaff();
        BeanUtils.copyProperties(authStaffQO, authStaff);
        AuthStaffVO authStaffVO = new AuthStaffVO();
        LambdaQueryWrapper<AuthStaff> queryWrapper = new LambdaQueryWrapper<AuthStaff>()
                .eq(AuthStaff::getStaffId, authStaffQO.getStaffId());
        authStaffMapper.update(authStaff, queryWrapper);
        BeanUtils.copyProperties(authStaffMapper.selectOne(queryWrapper), authStaffVO);
        return authStaffVO;
    }

    public Map addDoc(AddAuthStaffQO addAuthStaffQO) {
        String staffId = IdUtils.fastSimpleUUID();
        AuthStaff authStaff = new AuthStaff();
        authStaff.setStaffId(staffId);
        authStaff.setStaffName(addAuthStaffQO.getDocName());
        authStaff.setStaffGender(addAuthStaffQO.getDocGender());
        if(StringUtils.isNotEmpty(addAuthStaffQO.getDocBirth())){
            authStaff.setStaffBirth(Timestamp.valueOf(addAuthStaffQO.getDocBirth()));
        }
        authStaff.setStaffIdCard(addAuthStaffQO.getDocIdCard());
        authStaff.setStaffTel(addAuthStaffQO.getDocTel());
        authStaff.setStaffDesc(addAuthStaffQO.getDocDesc());
        authStaff.setStaffAccount(addAuthStaffQO.getDocAccount());
        String md5HashPassword = SecurityUtils.getMd5HashPassword(addAuthStaffQO.getDocPassword(), staffId, null);
        authStaff.setStaffPassword(md5HashPassword);
        authStaff.setStaffStatus(addAuthStaffQO.getDocStatus());
        authStaff.setStaffStatus(addAuthStaffQO.getDocStatus());
        authStaff.setStaffTitle(addAuthStaffQO.getDocTitle());
        authStaff.setCertificateNo(addAuthStaffQO.getDocCertificateNo());
        authStaff.setLicenseNo(addAuthStaffQO.getDocLicenceNo());
        authStaff.setSignatureUrl(addAuthStaffQO.getDocSignatureUrl());
        authStaff.setHeadImgUrl(addAuthStaffQO.getDocHeadImgUrl());
        authStaffMapper.insert(authStaff);
        Map map= new HashMap();
        map.put("docId",staffId);
        return map;
    }

    public Map modifyDoc(UpdataAuthStaffQO updataAuthStaffQO) {
        String staffId = IdUtils.fastSimpleUUID();
        AuthStaff authStaff = new AuthStaff();
        authStaff.setStaffId(staffId);
        authStaff.setStaffName(updataAuthStaffQO.getDocName());
        authStaff.setStaffGender(updataAuthStaffQO.getDocGender());
        if(StringUtils.isNotEmpty(updataAuthStaffQO.getDocBirth())){
            authStaff.setStaffBirth(Timestamp.valueOf(updataAuthStaffQO.getDocBirth()));
        }
        authStaff.setStaffIdCard(updataAuthStaffQO.getDocIdCard());
        authStaff.setStaffTel(updataAuthStaffQO.getDocTel());
        authStaff.setStaffDesc(updataAuthStaffQO.getDocDesc());
        authStaff.setStaffAccount(updataAuthStaffQO.getDocAccount());
        String md5HashPassword = SecurityUtils.getMd5HashPassword(updataAuthStaffQO.getDocPassword(), staffId, null);
        authStaff.setStaffPassword(md5HashPassword);
        authStaff.setStaffStatus(updataAuthStaffQO.getDocStatus());
        authStaff.setStaffStatus(updataAuthStaffQO.getDocStatus());
        authStaff.setStaffTitle(updataAuthStaffQO.getDocTitle());
        authStaff.setCertificateNo(updataAuthStaffQO.getDocCertificateNo());
        authStaff.setLicenseNo(updataAuthStaffQO.getDocLicenceNo());
        authStaff.setSignatureUrl(updataAuthStaffQO.getDocSignatureUrl());
        authStaff.setHeadImgUrl(updataAuthStaffQO.getDocHeadImgUrl());
        authStaffMapper.insert(authStaff);
        Map map= new HashMap();
        map.put("docId",staffId);
        return map;
    }

    public Map modifyDocStatusById(Map map) {
        LambdaQueryWrapper<AuthStaff> queryWrapper = new LambdaQueryWrapper<AuthStaff>()
                .eq(AuthStaff::getStaffId,map.get("docId"));
        AuthStaff authStaff = authStaffMapper.selectOne(queryWrapper);
        authStaff.setStaffStatus(map.get("statusCode").toString());
        authStaffMapper.update(authStaff,queryWrapper);
        return map;
    }


}
