package com.yimoom.pplay.domain.app.query;

import java.util.List;

public class PlayListQueryDo {
	private String name;
	private int role_num;
	private String difficulyName;
	private List<String> typeName;
	private String introduction;
	private int typekey;
	private int difficulyKey;
	private int timePeriods;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getRole_num() {
		return role_num;
	}
	public void setRole_num(int role_num) {
		this.role_num = role_num;
	}
	public String getDifficulyName() {
		return difficulyName;
	}
	public void setDifficulyName(String difficulyName) {
		this.difficulyName = difficulyName;
	}
	public List<String> getTypeName() {
		return typeName;
	}
	public void setTypeName(List<String> typeName) {
		this.typeName = typeName;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getTypekey() {
		return typekey;
	}
	public void setTypekey(int typekey) {
		this.typekey = typekey;
	}
	public int getDifficulyKey() {
		return difficulyKey;
	}
	public void setDifficulyKey(int difficulyKey) {
		this.difficulyKey = difficulyKey;
	}
	public int getTimePeriods() {
		return timePeriods;
	}
	public void setTimePeriods(int timePeriods) {
		this.timePeriods = timePeriods;
	}
	
}
