package com.banking.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.banking.spring.web.dao.TransactionsDao;

@Service("transactionsService")
public class TransactionsService {

	private TransactionsDao transactionsDao;

	@Autowired
	public void setTransactionsDao(TransactionsDao transactionsDao) {
		this.transactionsDao = transactionsDao;
	}

}
