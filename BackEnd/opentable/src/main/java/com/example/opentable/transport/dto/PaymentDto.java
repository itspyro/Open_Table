package com.example.opentable.transport.dto;

public class PaymentDto {
	int amount;
	int userId;
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public PaymentDto() {
		super();
		// TODO Auto-generated constructor stub
	}
}
