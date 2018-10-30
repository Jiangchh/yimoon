package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class SysUser implements UserDetails,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2572612936538494734L;
	private long uid;              
	private String name;           
	private String account; 
	private String nickName;      
	private String password;       
	private String icon;           
	private int gender;            
	private int age;               
	private long phoneNo;          
	private String mail;           
	private Date createDate;       
	private long version;          
	private int status;            
	private String remark;         
	private long orderNo;
	private int onlineStatus;
	private List<SysRole>list;
    private List<? extends GrantedAuthority> authorities;
    public SysUser() {}
    public SysUser(String account,String password,List<? extends GrantedAuthority> authorities) {
    	this.account=account;
    	this.password=password;
    	this.authorities=authorities;
    }
	public long getUid() {
		return uid;
	}
	public void setUid(long uid) {
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
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
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
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
		this.orderNo = orderNo;
	}
	public List<SysRole> getList() {
		return list;
	}
	public void setList(List<SysRole> list) {
		this.list = list;
	}
	
	public int getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(int onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public String getCredentialsSalt() {
		
		return "";
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		 return authorities;
	}
	@Override
	public String getUsername() {
		return account;
	}
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	@Override
	public boolean isEnabled() {
		return true;
	}
	public void setAuthorities(List<? extends GrantedAuthority> authorities) {
		this.authorities = authorities;
	}
	@Override
    public String toString() {
        return this.account;
    }

    @Override
    public int hashCode() {
        return this.account.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return this.toString().equals(obj.toString());
    }

	
}
