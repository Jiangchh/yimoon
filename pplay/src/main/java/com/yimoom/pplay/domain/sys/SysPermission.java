package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Date;

public class SysPermission implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4966048453266486925L;
	private long perId;            
	private String name;           
	private String url;              
	private int yype;              
	private long parent_id;         
	private String description;       
	private String remark;            
	private long orderNo;           
	private Date createDate;
	public long getPerId() {
		return perId;
	}
	public void setPerId(long perId) {
		this.perId = perId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public int getYype() {
		return yype;
	}
	public void setYype(int yype) {
		this.yype = yype;
	}
	public long getParent_id() {
		return parent_id;
	}
	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
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
