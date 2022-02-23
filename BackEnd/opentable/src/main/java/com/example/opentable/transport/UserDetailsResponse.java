package com.example.opentable.transport;

import java.io.Serializable;
import java.util.List;

import com.example.opentable.transport.dto.CreateUserDto;

public class UserDetailsResponse extends ResponseMessage implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2510215621076508764L;
	
	List<CreateUserDto> users;

	public UserDetailsResponse() {
		
	}

	public List<CreateUserDto> getUsers() {
		return users;
	}

	public void setUsers(List<CreateUserDto> users) {
		this.users = users;
	}

}
