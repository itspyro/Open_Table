package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.UserBookingsDto;

public class UserBookingsDetailsResponse extends ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2928674807077294510L;

	private int userId;
	
	List<UserBookingsDto> userBookings;

	public UserBookingsDetailsResponse() {
		super();
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<UserBookingsDto> getUserBookings() {
		return userBookings;
	}

	public void setUserBookings(List<UserBookingsDto> userBookings) {
		this.userBookings = userBookings;
	}
	
	
}
