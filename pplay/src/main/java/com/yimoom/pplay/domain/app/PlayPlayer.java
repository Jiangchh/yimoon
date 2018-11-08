package com.yimoom.pplay.domain.app;

import java.util.Date;

public class PlayPlayer {
	 private Long PlayerId;       
     private Long Pid;            
     private String Name;           
     private String Brief;          
     private String Mission;        
     private Long Version;        
     private String CreatorName;    
     private Date CreateDate;     
     private Integer Status;         
     private Long OrderNo;
	public Long getPlayerId() {
		return PlayerId;
	}
	public void setPlayerId(Long playerId) {
		PlayerId = playerId;
	}
	public Long getPid() {
		return Pid;
	}
	public void setPid(Long pid) {
		Pid = pid;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getBrief() {
		return Brief;
	}
	public void setBrief(String brief) {
		Brief = brief;
	}
	public String getMission() {
		return Mission;
	}
	public void setMission(String mission) {
		Mission = mission;
	}
	public Long getVersion() {
		return Version;
	}
	public void setVersion(Long version) {
		Version = version;
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
