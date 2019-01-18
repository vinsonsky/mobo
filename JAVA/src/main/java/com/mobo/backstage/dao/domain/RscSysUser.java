package com.mobo.backstage.dao.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class RscSysUser implements Serializable {
    private String userid;

    private String companyName;

    private String companyid;

    private String storename;

    private String rolename;

    private String brandcode;

    private String brandname;

    private String roleid;

    private String storecode;

    private String logonname;

    private String usercnname;

    private String userenname;

    private String position;

    private String password;

    private String pwd;

    private String storeid;

    private String storeids;

    private Integer status;

    private String mail;

    private String phone;

    private String mobile;

    private String sex;

    private String workstatus;

    private String photo;

    private String remark;

    private Integer usertype;

    private Integer inited;

    private String id;

    private String bankcardno;

    private String bankprovince;

    private String bankcity;

    private String branchbank;

    private String departmentid;

    private String wechatOpenID; //微信openid

    private String aliOpenID;//支付宝openid

    private String apiResultStatus;//登陆后返回结果集信息

    private Date createtime;

    private Date updatetime;

    private String def1;

    private String def2;

    private String def3;

    private String def4;

    private String def5;

    private String manager;
    private String flag;
    private String brand;

    private String nickName;

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getWechatOpenID() {
        return wechatOpenID;
    }

    public void setWechatOpenID(String wechatOpenID) {
        this.wechatOpenID = wechatOpenID;
    }

    public String getAliOpenID() {
        return aliOpenID;
    }

    public void setAliOpenID(String aliOpenID) {
        this.aliOpenID = aliOpenID;
    }

    public String getStoreid() {
        return storeid;
    }

    public void setStoreid(String storeid) {
        this.storeid = storeid;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    private static final long serialVersionUID = 1L;

    public String getStoreids() {
        return storeids;
    }

    public void setStoreids(String storeids) {
        this.storeids = storeids;
    }

    public String getManager() {
        return manager;
    }

    public void setManager(String manager) {
        this.manager = manager;
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getBrandname() {
        return brandname;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }

    public String getStorename() {
        return storename;
    }

    public void setStorename(String storename) {
        this.storename = storename;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getCompanyid() {
        return companyid;
    }

    public void setCompanyid(String companyid) {
        this.companyid = companyid;
    }

    public String getBrandcode() {
        return brandcode;
    }

    public void setBrandcode(String brandcode) {
        this.brandcode = brandcode;
    }

    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    public String getStorecode() {
        return storecode;
    }

    public void setStorecode(String storecode) {
        this.storecode = storecode;
    }

    public String getLogonname() {
        return logonname;
    }

    public void setLogonname(String logonname) {
        this.logonname = logonname;
    }

    public String getUsercnname() {
        return usercnname;
    }

    public void setUsercnname(String usercnname) {
        this.usercnname = usercnname;
    }

    public String getUserenname() {
        return userenname;
    }

    public void setUserenname(String userenname) {
        this.userenname = userenname;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getWorkstatus() {
        return workstatus;
    }

    public void setWorkstatus(String workstatus) {
        this.workstatus = workstatus;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getUsertype() {
        return usertype;
    }

    public void setUsertype(Integer usertype) {
        this.usertype = usertype;
    }

    public Integer getInited() {
        return inited;
    }

    public void setInited(Integer inited) {
        this.inited = inited;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBankcardno() {
        return bankcardno;
    }

    public void setBankcardno(String bankcardno) {
        this.bankcardno = bankcardno;
    }

    public String getBankprovince() {
        return bankprovince;
    }

    public void setBankprovince(String bankprovince) {
        this.bankprovince = bankprovince;
    }

    public String getBankcity() {
        return bankcity;
    }

    public void setBankcity(String bankcity) {
        this.bankcity = bankcity;
    }

    public String getBranchbank() {
        return branchbank;
    }

    public void setBranchbank(String branchbank) {
        this.branchbank = branchbank;
    }

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getUpdatetime() {
        return updatetime;
    }

    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }

    public String getDef1() {
        return def1;
    }

    public void setDef1(String def1) {
        this.def1 = def1;
    }

    public String getDef2() {
        return def2;
    }

    public void setDef2(String def2) {
        this.def2 = def2;
    }

    public String getDef3() {
        return def3;
    }

    public void setDef3(String def3) {
        this.def3 = def3;
    }

    public String getDef4() {
        return def4;
    }

    public void setDef4(String def4) {
        this.def4 = def4;
    }

    public String getDef5() {
        return def5;
    }

    public void setDef5(String def5) {
        this.def5 = def5;
    }

    @Override
    public String toString() {
        return "RscSysUser{" +
                "userid='" + userid + '\'' +
                ", companyName='" + companyName + '\'' +
                ", companyid='" + companyid + '\'' +
                ", storename='" + storename + '\'' +
                ", rolename='" + rolename + '\'' +
                ", brandcode='" + brandcode + '\'' +
                ", brandname='" + brandname + '\'' +
                ", roleid='" + roleid + '\'' +
                ", storecode='" + storecode + '\'' +
                ", logonname='" + logonname + '\'' +
                ", usercnname='" + usercnname + '\'' +
                ", userenname='" + userenname + '\'' +
                ", position='" + position + '\'' +
                ", password='" + password + '\'' +
                ", pwd='" + pwd + '\'' +
                ", storeid='" + storeid + '\'' +
                ", storeids='" + storeids + '\'' +
                ", status=" + status +
                ", mail='" + mail + '\'' +
                ", phone='" + phone + '\'' +
                ", mobile='" + mobile + '\'' +
                ", sex='" + sex + '\'' +
                ", workstatus='" + workstatus + '\'' +
                ", photo='" + photo + '\'' +
                ", remark='" + remark + '\'' +
                ", usertype=" + usertype +
                ", inited=" + inited +
                ", id='" + id + '\'' +
                ", bankcardno='" + bankcardno + '\'' +
                ", bankprovince='" + bankprovince + '\'' +
                ", bankcity='" + bankcity + '\'' +
                ", branchbank='" + branchbank + '\'' +
                ", departmentid='" + departmentid + '\'' +
                ", wechatOpenID='" + wechatOpenID + '\'' +
                ", aliOpenID='" + aliOpenID + '\'' +
                ", apiResultStatus='" + apiResultStatus + '\'' +
                ", createtime=" + createtime +
                ", updatetime=" + updatetime +
                ", def1='" + def1 + '\'' +
                ", def2='" + def2 + '\'' +
                ", def3='" + def3 + '\'' +
                ", def4='" + def4 + '\'' +
                ", def5='" + def5 + '\'' +
                ", manager='" + manager + '\'' +
                ", flag='" + flag + '\'' +
                ", brand='" + brand + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}