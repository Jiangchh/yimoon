package com.yimoom.pplay.domain;

public class TokenEntity {
	
    private String userId;
    private String token;
    public TokenEntity() {};
    public TokenEntity(String userId, String token) {
		super();
		this.userId = userId;
		this.token = token;
	}
	public String getUserId() {
		return userId;
	}
	
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
    
}
