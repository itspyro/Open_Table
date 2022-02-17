package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.CreateUserDto;
import com.example.opentable.transport.dto.UserDto;

public interface UserDao {

	int createUser(CreateUserDto createUserDto) throws Exception;

	List<UserDto> findById(int userId) throws Exception;
	
}
