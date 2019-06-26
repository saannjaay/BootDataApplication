package org.com.data.exception;

public class AdminErrorResponce {
	
	private String errorMessage;
	private int status;
	private long timeSt;
	public String getErrorMessage() {
		return errorMessage;
	}
	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public long getTimeSt() {
		return timeSt;
	}
	public void setTimeSt(long timeSt) {
		this.timeSt = timeSt;
	}
	
public AdminErrorResponce() {
	
}
public AdminErrorResponce(String errorMessage, int status, long timeSt) {
	super();
	this.errorMessage = errorMessage;
	this.status = status;
	this.timeSt = timeSt;
}



}
