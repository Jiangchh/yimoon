package com.yimoom.pplay.domain.app;

import java.util.Date;

public class PlayDrama {
	    private   Long Pid;            
	    private   Long PT_id;          
	    private   Long CreatorId;      
	    private   String CreatorName;    
	    private   String Introduction;   
	    private   Integer    Role_Num;
	    private   String Brief;          
	    private   String Details;        
	    private   Date CreateDate;     
	    private   Long Version;        
	    private   Integer Status;         
	    private   Long OrderNo;
		public Long getPid() {
			return Pid;
		}
		public void setPid(Long pid) {
			Pid = pid;
		}
		public Long getPT_id() {
			return PT_id;
		}
		public void setPT_id(Long pT_id) {
			PT_id = pT_id;
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
		public String getIntroduction() {
			return Introduction;
		}
		public void setIntroduction(String introduction) {
			Introduction = introduction;
		}
		public String getBrief() {
			return Brief;
		}
		public void setBrief(String brief) {
			Brief = brief;
		}
		public String getDetails() {
			return Details;
		}
		public void setDetails(String details) {
			Details = details;
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
		public Integer getRole_Num() {
			return Role_Num;
		}
		public void setRole_Num(Integer role_Num) {
			Role_Num = role_Num;
		}
		public void setStatus(Integer status) {
			Status = status;
		}
	    
}
