package com.banking.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.spring.web.dao.Account;
import com.banking.spring.web.dao.AccountsDao;

@Service("accountsService")
public class AccountsService {

	private AccountsDao accountsDao;

	@Autowired
	public void setAccountsDao(AccountsDao accountsDao) {
		this.accountsDao = accountsDao;
	}

	public List<Account> getAccounts(String username) {

		if (username == null) {
			return null;
		}

		List<Account> accounts = accountsDao.getAccounts(username);

		return accounts;
	}
}
