package com.mthree.restfulwebservice.exceptionhandling;

import java.util.Date;

public class ExceptionResponse {
	private Date timeStamp;
	private String messagge;
	private String details;
	
	public ExceptionResponse(Date timeStamp, String messagge, String details) {
		super();
		this.timeStamp = timeStamp;
		this.messagge = messagge;
		this.details = details;
	}
	public Date getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Date timeStamp) {
		this.timeStamp = timeStamp;
	}
	public String getMessagge() {
		return messagge;
	}
	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "ExceptionResponse [timeStamp=" + timeStamp + ", messagge=" + messagge + ", details=" + details + "]";
	}
	
	
}
