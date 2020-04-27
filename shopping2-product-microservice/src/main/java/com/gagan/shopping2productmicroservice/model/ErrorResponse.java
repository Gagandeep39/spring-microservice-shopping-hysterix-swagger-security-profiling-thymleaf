package com.gagan.shopping2productmicroservice.model;

public class ErrorResponse {
    private int status;
    private String message;
    private long timeStamp;

    public ErrorResponse(){}

    public ErrorResponse(int status, String message, long timestamp){
        this.status = status;
        this.message = message;
        this.timeStamp = timestamp;
    }

    public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
}