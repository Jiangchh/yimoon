package com.yimoom.pplay.exception;

public class AuthException extends Exception{
    /**
	 * 
	 */
	private static final long serialVersionUID = -3747299921226262364L;
	@SuppressWarnings("unused")
	private String msg;
    public AuthException(String msg) {
        super(msg);
        this.msg = msg;
    }
}
