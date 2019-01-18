package com.mobo.backstage.dao.mapper;

import com.mobo.backstage.dao.domain.RscSysUser;

import java.util.List;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 10:26
 * @Description:
 */
public interface RscSysUserMapper {

    void insertRscSysUser(RscSysUser rscSysUser);

    List<RscSysUser> selectRscSysUser(String mobile);
}
