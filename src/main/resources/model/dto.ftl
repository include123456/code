<#if dto??>
package com.sinovatech.b2b.b2b.model.dto;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;
    <#list packageSet as package >
import ${package};
    </#list>

/**
* 和易购系统c端用户信息
*
* @author shuyi
* @author wangyuheng
* @date 2019-1-16
*/
public class Tb2bCustomerDTO implements Serializable {
private static final long serialVersionUID = -5368763626309790387L;
/** 客户ID */
private String customerId;
/** 登录工号 */
private String loginCode;
/** 登录密码 */
private String password;
/** 手机号码 */
private String phoneNo;
/** 客户姓名 */
private String name;
/** 客户状态（0-待审核，1-审核通过，3-冻结） */
private String status;
/** 是否同意协议（0-未同意，1-已同意） */
private String agreementOrNot;
/** 注册时间 */
private Date registerTime;
/** 修改时间 */
private Date updateTime;
/** 冻结时间 */
private Date freezeTime;
/** 邮箱 */
private String email;

public Tb2bCustomerDTO() {}

public String getCustomerId() {
return customerId;
}

public void setCustomerId(String customerId) {
this.customerId = customerId;
}

public String getLoginCode() {
return loginCode;
}

public void setLoginCode(String loginCode) {
this.loginCode = loginCode;
}

public String getPassword() {
return password;
}

public void setPassword(String password) {
this.password = password;
}

public String getPhoneNo() {
return phoneNo;
}

public void setPhoneNo(String phoneNo) {
this.phoneNo = phoneNo;
}

public String getName() {
return name;
}

public void setName(String name) {
this.name = name;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}

public String getAgreementOrNot() {
return agreementOrNot;
}

public void setAgreementOrNot(String agreementOrNot) {
this.agreementOrNot = agreementOrNot;
}

public Date getRegisterTime() {
return registerTime;
}

public void setRegisterTime(Date registerTime) {
this.registerTime = registerTime;
}

public Date getUpdateTime() {
return updateTime;
}

public void setUpdateTime(Date updateTime) {
this.updateTime = updateTime;
}

public Date getFreezeTime() {
return freezeTime;
}

public void setFreezeTime(Date freezeTime) {
this.freezeTime = freezeTime;
}

public String getEmail() {
return email;
}

public void setEmail(String email) {
this.email = email;
}

@Override
public String toString() {
return JSON.toJSONString(this);
}
}
</#if>