package com.yimoom.pplay.domain.sys.query;

import java.util.Date;

import org.apache.ibatis.type.Alias;

import com.yimoom.pplay.common.base.entity.QueryBase;
@Alias("QuerySysUser")
public class QuerySysUser extends QueryBase{
	private Long uid;              
	private String name;           
	private String account; 
	private String nickName;      
	private String password;       
	private String icon;           
	private Integer gender;            
	private Integer age;               
	private Long phoneNo;          
	private String mail;           
	private Date createDate;       
	private Long version;          
	private Integer status;            
	private String remark;         
	private Long orderNo;
	private Integer onlineStatus;
	private Date lastAccessTime;
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(Long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Integer getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(Integer onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
	}
	
}
