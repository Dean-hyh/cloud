package com.dean.user.pojo.VO;

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
public class PeUserVO {

    private String userId;

    private String deptId;

    private String email;

    /**
     * 不能重复,可为中文
     */
    private String userName;

    private String station;

    /**
     * 1启用0停用
     */
    private BigDecimal state;

    private String companyId;

    private String companyName;

    private String deptName;

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

    private String joinDate;

    private Integer orderNo;

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

    public PeUserVO() {
    }

    public PeUserVO(String userId, String deptId, String email, String userName, String station, BigDecimal state, String companyId, String companyName, String deptName, String managerId, String gender, String telephone, String birthday, Integer degree, String joinDate, Integer orderNo, String createBy, String createDept, Date createTime, String updateBy, Date updateTime) {
        this.userId = userId;
        this.deptId = deptId;
        this.email = email;
        this.userName = userName;
        this.station = station;
        this.state = state;
        this.companyId = companyId;
        this.companyName = companyName;
        this.deptName = deptName;
        this.gender = gender;
        this.telephone = telephone;
        this.birthday = birthday;
        this.degree = degree;
        this.joinDate = joinDate;
        this.orderNo = orderNo;
    }
}
