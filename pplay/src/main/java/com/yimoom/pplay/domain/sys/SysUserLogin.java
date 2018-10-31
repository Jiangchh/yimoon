package com.yimoom.pplay.domain.sys;

import java.util.Date;

public class SysUserLogin {
	private Long id;             
	private Long uid;        
	private Date loginTime;  
	private String loginIp;    
	/**
	 * 登录来源 0：网页，1：app
	 */
	private int loginSrc;   
	private String remark;
	/**
	 * 微信，qq，支付宝等等
	 */
	private int identityType;
	/**
	 * (手机号/邮箱/用户名或第三方应用的唯一标识)
	 */
	private String identifier; 
	/**
	 *  (站内的保存密码 , 站外的不保存或保存 token)
	 */
	private String credential; 
	private Long orderNo;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getUid() {
		return uid;
	}
	public void setUid(Long uid) {
		this.uid = uid;
	}
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	public int getLoginSrc() {
		return loginSrc;
	}
	public void setLoginSrc(int loginSrc) {
		this.loginSrc = loginSrc;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public int getIdentityType() {
		return identityType;
	}
	public void setIdentityType(int identityType) {
		this.identityType = identityType;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getCredential() {
		return credential;
	}
	public void setCredential(String credential) {
		this.credential = credential;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	} 
	
}
