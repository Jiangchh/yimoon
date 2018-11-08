package com.yimoom.pplay.domain.app;

import java.util.Date;

public class PlayClue {
	 private Long Cid;             
     private Long Pid;             
     private Long Sid;             
     private String Name;            
     private String Description;     
     private Long CreatorId;       
     private String CreatorName;     
     private Date CreateDate;      
     private Long Version;         
     private Integer Status;          
     private Long OrderNo;
	public Long getCid() {
		return Cid;
	}
	public void setCid(Long cid) {
		Cid = cid;
	}
	public Long getPid() {
		return Pid;
	}
	public void setPid(Long pid) {
		Pid = pid;
	}
	public Long getSid() {
		return Sid;
	}
	public void setSid(Long sid) {
		Sid = sid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public Long getCreatorId() {
		return CreatorId;
	}
	public void setCreatorId(Long creatorId) {
		CreatorId = creatorId;
	}
	public String getCreatorName() {
		return CreatorName;
	}
	public void setCreatorName(String creatorName) {
		CreatorName = creatorName;
	}
	public Date getCreateDate() {
		return CreateDate;
	}
	public void setCreateDate(Date createDate) {
		CreateDate = createDate;
	}
	public Long getVersion() {
		return Version;
	}
	public void setVersion(Long version) {
		Version = version;
	}
	public Integer getStatus() {
		return Status;
	}
	public void setStatus(Integer status) {
		Status = status;
	}
	public Long getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(Long orderNo) {
		OrderNo = orderNo;
	}   
     
}
