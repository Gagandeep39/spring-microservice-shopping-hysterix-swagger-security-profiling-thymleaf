/**
 * @author Gagandeep Singh
 * @email singh.gagandeep3911@gmail.com
 * @create date 2020-04-22 22:16:07
 * @modify date 2020-04-22 22:16:07
 * @desc [description]
 */
package com.gagan.shopping2purchasemicroservice.model;

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