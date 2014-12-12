package com.banking.spring.web.controllers;

import java.util.Calendar;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.spring.web.dao.Transaction;
import com.banking.spring.web.service.AccountsService;
import com.banking.spring.web.service.TransactionsService;
import com.banking.spring.web.utils.IbanGenerator;

@Controller
public class TransactionsController {

	private TransactionsService transactionsService;
	private AccountsService accountsService;

	@Autowired
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@Autowired
	public void setTransactionsService(TransactionsService transactionsService) {
		this.transactionsService = transactionsService;
	}

	@RequestMapping(value = "/paybills", method = RequestMethod.POST)
	public String payBillz(@Valid Transaction transaction, BindingResult result) {

		/*
		 * / EDIT - Should return some error page!!!
		 */
		if (result.hasErrors()) {
			return "home";
		}

		// transactionsService.createTransaction(transaction);

		/*
		 * // create a java calendar instance Calendar calendar =
		 * Calendar.getInstance();
		 * 
		 * // get a java date (java.util.Date) from the Calendar instance. //
		 * this java date will represent the current date, or "now".
		 * java.util.Date currentDate = calendar.getTime();
		 * 
		 * // now, create a java.sql.Date from the java.util.Date java.sql.Date
		 * date = new java.sql.Date(currentDate.getTime());
		 */

		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime()
				.getTime());

		Calendar cal = Calendar.getInstance();
		java.sql.Time now = java.sql.Time.valueOf(cal.get(Calendar.HOUR_OF_DAY)
				+ ":" + cal.get(Calendar.MINUTE) + ":"
				+ cal.get(Calendar.SECOND));

		transaction.setDate(date);
		transaction.setTime(now);

		transactionsService.create(transaction);

		System.out.println(transaction);
		System.out.println(IbanGenerator.generateIban());

		return "paybills";
	}

}
