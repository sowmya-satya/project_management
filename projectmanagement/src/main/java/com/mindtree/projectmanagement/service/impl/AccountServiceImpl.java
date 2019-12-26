package com.mindtree.projectmanagement.service.impl;

import java.util.Collections;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.projectmanagement.dto.AccountDto;
import com.mindtree.projectmanagement.dto.IgDto;
import com.mindtree.projectmanagement.entity.Account;
import com.mindtree.projectmanagement.entity.Ig;
import com.mindtree.projectmanagement.entity.Project;
import com.mindtree.projectmanagement.exception.AccountAlreadyExistsException;
import com.mindtree.projectmanagement.exception.AccountDoesNotExists;
import com.mindtree.projectmanagement.exception.IgDoesNotExists;
import com.mindtree.projectmanagement.exception.ServiceException;
import com.mindtree.projectmanagement.exception.TotalAccountCostMoreThanRevenue;
import com.mindtree.projectmanagement.exception.util.ErrorConstants;
import com.mindtree.projectmanagement.repository.AccountRepository;
import com.mindtree.projectmanagement.repository.IgRepository;
import com.mindtree.projectmanagement.repository.ProjectRepository;
import com.mindtree.projectmanagement.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService{
	
	@Autowired
	private IgRepository igRepo;
	
	@Autowired
	private ProjectRepository projectRepo;
	
	@Autowired
	private AccountRepository accountRepo;
	
	ModelMapper modelMapper = new ModelMapper();
	

	@Override
	public AccountDto insertAccountProduct(AccountDto accountDto) throws ServiceException {
		// TODO Auto-generated method stub
		Account account =modelMapper.map(accountDto, Account.class);
		
		Account existingAccount =null;
		
	//	Project existingProject = null;
		
		List<Account> accountList = accountRepo.findAll();
		
	//	List<Project> projectList = projectRepo.findAll();
		
		for (Account account2 : accountList) {
			if(account2.getAccountName().equalsIgnoreCase(account.getAccountName())) {
				existingAccount=account2;
				break;
			}
			
		}
		if (existingAccount !=null){
			throw new AccountAlreadyExistsException(ErrorConstants.ACCOUNTALREADYEXISTS);
		}
		else {
			 int allProjectCost = 0;
		
		for (Project p : account.getProjects()) {
			allProjectCost = allProjectCost + p.getCost();
		}
		if(allProjectCost<=account.getRevenue()) {
			accountRepo.save(account);
			return modelMapper.map(account, AccountDto.class);
		}
		else {
			throw new TotalAccountCostMoreThanRevenue(ErrorConstants.TOTALACCOUNTCOSTMORETHANREVENUE);
		}
	}

	}


	@Override
	public IgDto assignAccountToIG(int accountId, int igId) throws ServiceException   {
		// TODO Auto-generated method stub
		Account existingAccount = null;
		
		Ig existingIg = null;
		List<Account> accountList = accountRepo.findAll();
		
		List<Ig> igList = igRepo.findAll();
		for (Account account : accountList) {
			if(account.getAccountId()==accountId) {
				existingAccount=account;
				break;
			}
			
		}
		for (Ig ig : igList) {
			if(ig.getIgId()==igId) {
				existingIg=ig;
				break;
			}
		}
		if(existingAccount==null) {
			throw new AccountDoesNotExists(ErrorConstants.ACCOUNTDOESNOTEXISTS);
		}
		if(existingIg==null) {
			throw new IgDoesNotExists(ErrorConstants.IGDOESNOTEXISTS);
		}
		existingIg.getAccounts().add(existingAccount);
		igRepo.save(existingIg);
		return modelMapper.map(existingIg, IgDto.class);
	}


	@Override
	public IgDto sortAccount(int igId) throws ServiceException {
		// TODO Auto-generated method stub
		Ig existingIg = null;
		List<Ig> igList = igRepo.findAll();
		for (Ig ig : igList) {
			if(ig.getIgId()==igId) {
				existingIg = ig;
			}
			
		}
		if(existingIg==null) {
				throw new IgDoesNotExists(ErrorConstants.IGDOESNOTEXISTS);
		}
		else {
			Collections.sort(existingIg.getAccounts());
		}
		
		
		return modelMapper.map(existingIg, IgDto.class);
	}

}
