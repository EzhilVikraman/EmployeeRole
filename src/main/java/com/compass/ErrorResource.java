package com.compass;

import org.springframework.http.HttpStatus;

public class ErrorResource {
	private HttpStatus status;
	private String errorMsg;
	private int errorCode;
	
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus badRequest) {
		this.status = badRequest;
	}
	public String getErrorMsg() {
		return errorMsg;
	}
	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	public int getErrorCode() {
		return errorCode;
	}
	public void setErrorCode(int errorCode) {
		this.errorCode = errorCode;
	}

}