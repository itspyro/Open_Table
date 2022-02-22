package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.CreateUserDto;
import com.example.opentable.transport.dto.UserDto;

public interface UserService {

	int createUser(CreateUserDto createUserDto) throws Exception;

	List<UserDto> findById(int userId) throws Exception;
	
}
