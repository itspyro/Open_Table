package com.example.opentable.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="BookingTable")
public class Booking {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int BookingId;

@OneToOne(mappedBy = "foodorderId")
private Foodorder foodorder;

@OneToOne(mappedBy = "userId")
private User user;

@OneToOne(mappedBy = "TableorderId")
private Tableorder tableorderId;

@Column
private String paymentId;

public Booking() {

}

public Booking(int bookingId, Foodorder foodorder, User user, Tableorder tableorderId, String paymentId) {
	super();
	BookingId = bookingId;
	this.foodorder = foodorder;
	this.user = user;
	this.tableorderId = tableorderId;
	this.paymentId = paymentId;
}

public int getBookingId() {
	return BookingId;
}

public void setBookingId(int bookingId) {
	BookingId = bookingId;
}

public Foodorder getFoodorder() {
	return foodorder;
}

public void setFoodorder(Foodorder foodorder) {
	this.foodorder = foodorder;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public Tableorder getTableorderId() {
	return tableorderId;
}

public void setTableorderId(Tableorder tableorderId) {
	this.tableorderId = tableorderId;
}

public String getPaymentId() {
	return paymentId;
}

public void setPaymentId(String paymentId) {
	this.paymentId = paymentId;
}

@Override
public String toString() {
	return "Booking [BookingId=" + BookingId + ", foodorder=" + foodorder + ", user=" + user + ", tableorderId="
			+ tableorderId + ", paymentId=" + paymentId + "]";
}




	
}
