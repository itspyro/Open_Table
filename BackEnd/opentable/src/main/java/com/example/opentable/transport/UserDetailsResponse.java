package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.UserDto;

public class UserDetailsResponse extends ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2510215621076508764L;
	
	List<UserDto> users;

	public UserDetailsResponse() {
		
	}

	public List<UserDto> getUsers() {
		return users;
	}

	public void setUsers(List<UserDto> users) {
		this.users = users;
	}

}
