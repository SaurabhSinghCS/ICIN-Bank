package com.simplilearn.workshop.response;

public class UpdateResponseDetails {

	private boolean transferStatus;
	private String responseMessage;
	
	public boolean isTransferStatus() {
		return transferStatus;
	}
	
	public void setTransferStatus(boolean transferStatus) {
		this.transferStatus = transferStatus;
	}
	
	public String getResponseMessage() {
		return responseMessage;
	}
	
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
}
