package com.yimoom.pplay.domain.sys;

import java.io.Serializable;
import java.util.Date;

public class SysPermission implements Serializable{
	/**
	 * 
	 */
	private static final Long serialVersionUID = -4966048453266486925L;
	private Long perId;            
	private String name;           
	private String url;              
	private Integer yype;              
	private Long parentId;         
	private String description;       
	private String remark;            
	private Long orderNo;           
	private Date createDate;
	public Long getPerId() {
		return perId;
	}
	public void setPerId(Long perId) {
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
	public Integer getYype() {
		return yype;
	}
	public void setYype(Integer yype) {
		this.yype = yype;
	}
	
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
	
}
