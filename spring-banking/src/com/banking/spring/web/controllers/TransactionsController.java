package com.banking.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.spring.web.dao.Transaction;
import com.banking.spring.web.service.AccountsService;
import com.banking.spring.web.service.TransactionsService;
import com.banking.spring.web.utils.DateTime;
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

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		transaction.setDate(new DateTime().getCurrentDate());
		transaction.setTime(new DateTime().getCurrentTime());

		transactionsService.create(transaction);

		System.out.println(transaction);
		System.out.println(IbanGenerator.generateIban());

		return "transfercompleted";
	}

	@RequestMapping(value = "/transfermoneytouser", method = RequestMethod.POST)
	public String transferMoneyToUser(@Valid Transaction transaction,
			BindingResult result) {

		/*
		 * / EDIT - Should return some error page!!!
		 */
		if (result.hasErrors()) {
			return "home";
		}

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		transaction.setDate(new DateTime().getCurrentDate());
		transaction.setTime(new DateTime().getCurrentTime());

		/*
		 * / EDIT - Should return some error page!!!
		 */
		if (!accountsService.exists(transaction.getRecipientIban())) {
			result.rejectValue("recipientIban",
					"NoneExistingIban.transaction.recipientIban");
			return "home";
		}

		transactionsService.createBankClientTransaction(transaction);

		System.out.println(transaction);
		System.out.println(IbanGenerator.generateIban());

		return "transfercompleted";
	}

}
