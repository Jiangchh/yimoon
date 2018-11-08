package com.yimoom.pplay.domain.app;

import java.util.Date;

public class PlayType {
    private Long PTid;          
    private String Name;          
    private String Description;   
    private Long CreatorId;     
    private String CreatorName;   
    private Date CreateDate;    
	private Long Version;       
	private Integer Status;        
    private Long OrderNo;
	public Long getPTid() {
		return PTid;
	}
	public void setPTid(Long pTid) {
		PTid = pTid;
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
	public int getStatus() {
		return Status;
	}
	public void setStatus(int status) {
		Status = status;
	}
	public Long getOrderNo() {
		return OrderNo;
	}
	public void setOrderNo(Long orderNo) {
		OrderNo = orderNo;
	}
    
}
