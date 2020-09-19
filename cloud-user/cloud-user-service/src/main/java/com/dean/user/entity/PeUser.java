package com.dean.user.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author Dean
 * @since 2020-09-18
 */
public class PeUser extends Model<PeUser> {

private static final long serialVersionUID=1L;

    private String userId;

    private String deptId;

    private String email;

    /**
     * 不能重复,可为中文
     */
    private String userName;

    private String station;

    /**
     * shiro MD5密码32位
     */
    private String password;

    /**
     * 1启用0停用
     */
    private BigDecimal state;

    private String companyId;

    private String companyName;

    private String deptName;

    private String managerId;

    private String gender;

    private String telephone;

    private String birthday;

    /**
     * 0 作为内部控制，租户企业不能使用
0-saas 管理员
1-企业管理员
2-管理所有下属部门和人员
3-管理本部门
4-普通员工
     */
    private Integer degree;

    private BigDecimal salary;

    private String joinDate;

    private Integer orderNo;

    /**
     * 登录人编号
     */
    private String createBy;

    /**
     * 登录人所属部门编号
     */
    private String createDept;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

    private String remark;

    /**
     * 微信Id
     */
    private String openId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public BigDecimal getState() {
        return state;
    }

    public void setState(BigDecimal state) {
        this.state = state;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getManagerId() {
        return managerId;
    }

    public void setManagerId(String managerId) {
        this.managerId = managerId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public Integer getDegree() {
        return degree;
    }

    public void setDegree(Integer degree) {
        this.degree = degree;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public String getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(String joinDate) {
        this.joinDate = joinDate;
    }

    public Integer getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(Integer orderNo) {
        this.orderNo = orderNo;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public String getCreateDept() {
        return createDept;
    }

    public void setCreateDept(String createDept) {
        this.createDept = createDept;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "PeUser{" +
        "userId=" + userId +
        ", deptId=" + deptId +
        ", email=" + email +
        ", userName=" + userName +
        ", station=" + station +
        ", password=" + password +
        ", state=" + state +
        ", companyId=" + companyId +
        ", companyName=" + companyName +
        ", deptName=" + deptName +
        ", managerId=" + managerId +
        ", gender=" + gender +
        ", telephone=" + telephone +
        ", birthday=" + birthday +
        ", degree=" + degree +
        ", salary=" + salary +
        ", joinDate=" + joinDate +
        ", orderNo=" + orderNo +
        ", createBy=" + createBy +
        ", createDept=" + createDept +
        ", createTime=" + createTime +
        ", updateBy=" + updateBy +
        ", updateTime=" + updateTime +
        ", remark=" + remark +
        ", openId=" + openId +
        "}";
    }
}
