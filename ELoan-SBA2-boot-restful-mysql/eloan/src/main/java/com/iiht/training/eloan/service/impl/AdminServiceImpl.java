package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private UsersRepository usersRepository;

	private UserDto convertEntityToOutputDto(Users user) {
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		userDto.setMobile(user.getMobile());

		return userDto;
	}

	private Users convertInputDtoToEntity(UserDto userDto) {
		Users users = new Users();
		users.setId(userDto.getId());
		users.setFirstName(userDto.getFirstName());
		users.setLastName(userDto.getLastName());
		users.setEmail(userDto.getEmail());
		users.setMobile(userDto.getMobile());

		return users;
	}


	@Override
	public UserDto registerClerk(UserDto userDto) {
		// TODO Auto-generated method stub
		Users users = this.convertInputDtoToEntity(userDto);
		// save into DB, returns newly added record
		Users newUser = this.usersRepository.save(users);
		// convert entity into dto
		UserDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

	@Override
	public UserDto registerManager(UserDto userDto) {
		// TODO Auto-generated method stub
		Users users = this.convertInputDtoToEntity(userDto);
		// save into DB, returns newly added record
		Users newUser = this.usersRepository.save(users);
		// convert entity into dto
		UserDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

	@Override
	public List<UserDto> getAllClerks() {
		// TODO Auto-generated method stub
		List<Users> users = this.usersRepository.findAll();

		List<UserDto> usersDtos = users.stream().map(this::convertEntityToOutputDto).collect(Collectors.toList());
		return usersDtos;
	}

	@Override
	public List<UserDto> getAllManagers() {
		// TODO Auto-generated method stub

		List<Users> users = this.usersRepository.findAll();

		List<UserDto> usersDtos = users.stream().map(this::convertEntityToOutputDto)
				.collect(Collectors.toList());
		return usersDtos;
	}

}
