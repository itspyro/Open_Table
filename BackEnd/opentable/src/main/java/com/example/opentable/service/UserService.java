package com.example.opentable.service;

import java.util.List;

import com.example.opentable.transport.dto.LoginDto;
import com.example.opentable.transport.dto.RegisterUserDto;
import com.example.opentable.transport.dto.UpdateUserDto;
import com.example.opentable.transport.dto.UserDto;
import com.example.opentable.transport.dto.UserPhotoDto;

public interface UserService {

	int createUser(RegisterUserDto registerUserDto) throws Exception;

	List<UserDto> findById(int userId) throws Exception;
	
	int login(LoginDto loginDto) throws Exception;

	int updateUser(UpdateUserDto userDto) throws Exception;

	void updatePhoto(UserPhotoDto photoDto) throws Exception;
	
}
