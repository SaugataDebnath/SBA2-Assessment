package com.iiht.training.eloan.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iiht.training.eloan.dto.LoanOutputDto;
import com.iiht.training.eloan.dto.ProcessingDto;
import com.iiht.training.eloan.entity.Loan;
import com.iiht.training.eloan.entity.SanctionInfo;
import com.iiht.training.eloan.repository.LoanRepository;
import com.iiht.training.eloan.repository.ProcessingInfoRepository;
import com.iiht.training.eloan.repository.SanctionInfoRepository;
import com.iiht.training.eloan.repository.UsersRepository;
import com.iiht.training.eloan.service.ClerkService;

@Service
public class ClerkServiceImpl implements ClerkService {

	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private LoanRepository loanRepository;

	@Autowired
	private ProcessingInfoRepository pProcessingInfoRepository;

	@Autowired
	private SanctionInfoRepository sanctionInfoRepository;


	private LoanOutputDto convertEntityToOutputDto(Loan loan) {
		LoanOutputDto loanOutputDto = new LoanOutputDto();
		loanOutputDto.setCustomerId(loan.getCustomerId());
		loanOutputDto.setLoanAppId(loanOutputDto.getLoanAppId());
		loanOutputDto.setUserDto(loanOutputDto.getUserDto());
		loanOutputDto.setLoanDto(loanOutputDto.getLoanDto());
		loanOutputDto.setProcessingDto(loanOutputDto.getProcessingDto());
		loanOutputDto.setSanctionOutputDto(loanOutputDto.getSanctionOutputDto());;
		loanOutputDto.setStatus(loan.getStatus());
		loanOutputDto.setRemark(loan.getRemark());

		return loanOutputDto;
	}

	@Override
	public List<LoanOutputDto> allAppliedLoans() {
		// TODO Auto-generated method stub
		List<Loan> loan = this.loanRepository.findAll();
		List<LoanOutputDto> loanOutputDtos = loan.stream().map(this::convertEntityToOutputDto)
				.collect(Collectors.toList());
		return loanOutputDtos;
	}

	@Override
	public ProcessingDto processLoan(Long clerkId, Long loanAppId, ProcessingDto processingDto) {
		// TODO Auto-generated method stub
		return null;
	}

}
