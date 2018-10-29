package com.yimoom.pplay.domain.sys;

import java.util.Date;

public class SysPost {
	private long pid ;                    
	private String post_Name ;              
	private String description;             
	private String remark ;                 
	private int status;                  
	private long version;                 
	private long orderNo ;                
	private Date createDate;
	public long getPid() {
		return pid;
	}
	public void setPid(long pid) {
		this.pid = pid;
	}
	public String getPost_Name() {
		return post_Name;
	}
	public void setPost_Name(String post_Name) {
		this.post_Name = post_Name;
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
	
	
}
