package com.example.opentable.transport.dto;

public class PaymentUpdateDto {
	private String order_id;
	private String payment_id;
	private String status;
	public String getOrder_id() {
		return order_id;
	}
	public void setOrder_id(String order_id) {
		this.order_id = order_id;
	}
	public PaymentUpdateDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(String payment_id) {
		this.payment_id = payment_id;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
