package com.example.opentable.transport.dto;

public class PaymentUpdateDto {
	private String orderId;
	private String paymentId;
	private String status;
	
	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public PaymentUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
