package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.type.Alias;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
@Alias("SysUser")
public class SysUser implements UserDetails,Serializable {
	/**
	 * 
	 */
	private static final Long serialVersionUID = 2572612936538494734L;
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
	private List<SysRole>list;
    private List<? extends GrantedAuthority> authorities;
    public SysUser() {}
    public SysUser(String account,String password,List<? extends GrantedAuthority> authorities) {
    	this.account=account;
    	this.password=password;
    	this.authorities=authorities;
    }
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
	public List<SysRole> getList() {
		return list;
	}
	public void setList(List<SysRole> list) {
		this.list = list;
	}
	
	public Integer getOnlineStatus() {
		return onlineStatus;
	}
	public void setOnlineStatus(Integer onlineStatus) {
		this.onlineStatus = onlineStatus;
	}
	public String getCredentialsSalt() {
		
		return "";
	}
	
	public Date getLastAccessTime() {
		return lastAccessTime;
	}
	public void setLastAccessTime(Date lastAccessTime) {
		this.lastAccessTime = lastAccessTime;
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
    public boolean equals(Object usr) {
    	if (usr instanceof SysUser) {
            return account.equals(((SysUser) usr).account);
        }
        return false;
    }

	
}
