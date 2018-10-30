package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class SysRole implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = 3743263367863889466L;
	private long   rid;           
    private String  role_Name;    
    private String  description;     
    private String  remark;          
    private int  status;          
    private long  version;         
    private long  orderNo;         
    private Date  createDate;
    private List<SysPermission>Plist;
    private List<SysPost>list;
	public long getRid() {
		return rid;
	}
	public void setRid(long rid) {
		this.rid = rid;
	}
	public String getRole_Name() {
		return role_Name;
	}
	public void setRole_Name(String role_Name) {
		this.role_Name = role_Name;
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
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getVersion() {
		return version;
	}
	public void setVersion(long version) {
		this.version = version;
	}
	public long getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(long orderNo) {
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
