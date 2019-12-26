package com.mindtree.projectmanagement.service;

import com.mindtree.projectmanagement.dto.AccountDto;
import com.mindtree.projectmanagement.dto.IgDto;
import com.mindtree.projectmanagement.exception.ServiceException;

public interface AccountService {

	public AccountDto insertAccountProduct(AccountDto accountDto) throws ServiceException;

	public IgDto assignAccountToIG(int accountId, int igId) throws ServiceException;

	public IgDto sortAccount(int igId) throws ServiceException;

}
