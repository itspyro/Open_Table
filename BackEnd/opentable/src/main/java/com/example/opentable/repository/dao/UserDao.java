package com.example.opentable.repository.dao;

import java.util.List;

import com.example.opentable.transport.dto.LoginDto;
import com.example.opentable.transport.dto.RegisterUserDto;
import com.example.opentable.transport.dto.UserDto;

public interface UserDao {

	int createUser(RegisterUserDto registerUserDto) throws Exception;

	List<UserDto> findById(int userId) throws Exception;
	
	int login(LoginDto loginDto) throws Exception;
	
}
