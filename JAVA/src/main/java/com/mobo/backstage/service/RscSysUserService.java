package com.mobo.backstage.service;

import com.mobo.backstage.dao.domain.RscSysUser;

import java.util.List;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 09:52
 * @Description:
 */
public interface RscSysUserService {

    void insertRscSysUser(RscSysUser rscSysUser);

    List<RscSysUser> selectRscSysUser(String mobile);
}
