package com.mobo.backstage.controller;

import com.mobo.backstage.constant.ApiResult;
import com.mobo.backstage.constant.ResultCode;
import com.mobo.backstage.dao.domain.RscSysUser;
import com.mobo.backstage.service.RscSysUserService;
import com.mobo.backstage.util.SnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Auther: chengyunyi
 * @Date: 2019/1/18 09:57
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class RscSysUserController {

    @Autowired
    private RscSysUserService rscSysUserService;

    @RequestMapping("/insert")
    public ApiResult insert(){
        ApiResult result = new ApiResult();
        RscSysUser rscSysUser=new RscSysUser();
        rscSysUser.setUserid(SnowflakeIdWorker.getInstance().nextId()+"");
        rscSysUser.setLogonname("12345678901");
        rscSysUser.setMobile("12345678901");
        rscSysUser.setUsercnname("mobo测试");
        rscSysUser.setStatus(ResultCode.SUCCESS_CODE);
        rscSysUserService.insertRscSysUser(rscSysUser);
        return result;
    }

    @RequestMapping("/select/{mobile}")
    public ApiResult select(@PathVariable("mobile") String mobile){
        ApiResult result = new ApiResult();
        List<RscSysUser> rscSysUsers = rscSysUserService.selectRscSysUser(mobile);
        result.setData(rscSysUsers);
        return result;
    }
}
