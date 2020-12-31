package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanDto;
import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.UserDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.Users;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;

	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;

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

	private LoanOutputDto convertEntityToOutputDto(Loan loan) {
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		loanOutputDto.setCustomerId(loan.getCustomerId());
		loanOutputDto.setLoanAppId(loanOutputDto.getLoanAppId());
		loanOutputDto.setStatus(loan.getStatus());
		loanOutputDto.setRemark(loan.getRemark());

		return loanOutputDto;
	}

	@Override
	public UserDto register(UserDto userDto) {
		// TODO Auto-generated method stub
		// convert dto into entity
		Users users = this.convertInputDtoToEntity(userDto);
		// save into DB, returns newly added record
		Users newUser = this.usersRepository.save(users);
		// convert entity into dto
		UserDto userOutputDto = this.convertEntityToOutputDto(newUser);
		return userOutputDto;
	}

	@Override
	public LoanOutputDto applyLoan(Long customerId, LoanDto loanDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LoanOutputDto getStatus(Long loanAppId) {
		// TODO Auto-generated method stub
		if (this.loanRepository.existsById(loanAppId)) {
			Loan loan = this.loanRepository.findById(loanAppId).orElse(null);
			LoanOutputDto loanOutputDto = this.convertEntityToOutputDto(loan);
			return loanOutputDto;
		}
		return null;
	}

	@Override
	public List<LoanOutputDto> getStatusAll(Long customerId) {
		// TODO Auto-generated method stub
		List<Loan> loan = this.loanRepository.findById(customerId);
		List<LoanOutputDto> loanOutputDto =
				loan.stream()
						 .map(this :: convertEntityToOutputDto)
						 .collect(Collectors.toList());
		return loanOutputDto;
	}

}
