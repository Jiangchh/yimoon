package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysRole implements Serializable{
    /**
	 * 
	 */
	private static final Long serialVersionUID = 3743263367863889466L;
	private Long   rid;           
    private String  roleName;    
    private String  description;     
    private String  remark;          
    private Integer  status;          
    private Long  version;         
    private Long  orderNo;         
    private Date  createDate;
    private List<SysPermission>Plist;
    private List<SysPost>list;
	public Long getRid() {
		return rid;
	}
	public void setRid(Long rid) {
		this.rid = rid;
	}
	
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Long getVersion() {
		return version;
	}
	public void setVersion(Long version) {
		this.version = version;
	}
	public Long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(Long orderNo) {
		this.orderNo = orderNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<SysPermission> getPlist() {
		return Plist;
	}
	public void setPlist(List<SysPermission> plist) {
		Plist = plist;
	}
	public List<SysPost> getList() {
		return list;
	}
	public void setList(List<SysPost> list) {
		this.list = list;
	}
	

}
