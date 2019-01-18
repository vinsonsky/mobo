package com.mobo.backstage.service.impl;

import com.mobo.backstage.dao.annotation.ReadOnly;
import com.mobo.backstage.dao.domain.RscSysUser;
import com.mobo.backstage.dao.mapper.RscSysUserMapper;
import com.mobo.backstage.service.RscSysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 09:55
 * @Description:
 */
@Service
public class RscSysUserServiceImpl implements RscSysUserService{

    private static final Logger LOGGER = LoggerFactory.getLogger(RscSysUserServiceImpl.class);
    @Autowired
    private RscSysUserMapper rscSysUserMapper;

    @Override
    public void insertRscSysUser(RscSysUser rscSysUser) {
        rscSysUserMapper.insertRscSysUser(rscSysUser);
    }

    @Override
    @ReadOnly(methodName = "selectRscSysUser")
    public List<RscSysUser> selectRscSysUser(String mobile) {
        return rscSysUserMapper.selectRscSysUser(mobile);
    }
}
