package com.banking.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.spring.web.dao.Deposit;
import com.banking.spring.web.dao.DepositsDao;

@Service
public class DepositsService {
	
	private DepositsDao depositsDao;

	@Autowired
	public void setDepositsDao(DepositsDao depositsDao) {
		this.depositsDao = depositsDao;
	}

	public List<Deposit> getDeposits(String username) {

		if (username == null) {
			return null;
		}

		List<Deposit> deposits = depositsDao.getDeposits(username);

		return deposits;
	}

}
