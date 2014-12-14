package com.banking.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.spring.web.dao.Deposit;
import com.banking.spring.web.dao.Transaction;
import com.banking.spring.web.service.AccountsService;
import com.banking.spring.web.service.TransactionsService;
import com.banking.spring.web.utils.DateTime;
import com.banking.spring.web.utils.IbanGenerator;

@Controller
public class TransactionsController {
	private static final int THREE_MONTHS = 3;
	private static final int TWELVE_MONTHS = 12;
	private static final double THREE_MONTHS_INTEREST = 4;
	private static final double TWELVE_MONTHS_INTEREST = 6;

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

		if (result.hasErrors()) {
			return "invalidinput";
		}

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		transaction.setDate(DateTime.getCurrentDate());
		transaction.setTime(DateTime.getCurrentTime());

		transactionsService.create(transaction);

		System.out.println(transaction);
		System.out.println(IbanGenerator.generateIban());

		return "transfercompleted";
	}

	@RequestMapping(value = "/transfermoneytouser", method = RequestMethod.POST)
	public String transferMoneyToUser(@Valid Transaction transaction,
			BindingResult result) {

		if (result.hasErrors()) {
			return "invalidinput";
		}

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		transaction.setDate(DateTime.getCurrentDate());
		transaction.setTime(DateTime.getCurrentTime());

		if (!accountsService.exists(transaction.getRecipientIban())) {
			result.rejectValue("recipientIban",
					"NoneExistingIban.transaction.recipientIban");
			return "invalidinput";
		}

		transactionsService.createBankClientTransaction(transaction);

		return "transfercompleted";
	}

	@RequestMapping(value = "/openbankaccount", method = RequestMethod.POST)
	public String openBankAccount(@Valid Transaction transaction,
			BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return "invalidinput";
		}

		if (accountsService.exists(transaction.getRecipientIban())) {
			String recipientIban = null;
			while (true) {
				recipientIban = IbanGenerator.generateIban();
				if (!accountsService.exists(recipientIban)) {
					transaction.setRecipientIban(recipientIban);
					break;
				}
			}
		}

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		String username = principal.getName();

		transaction.setDate(DateTime.getCurrentDate());
		transaction.setTime(DateTime.getCurrentTime());

		transactionsService.createAccount(transaction, username);

		return "transfercompleted";
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.POST)
	public String transactionHistory(Transaction transaction, Model model) {

		String accountIban = transaction.getInitiatorIban();
		List<Transaction> transactions = transactionsService
				.getAccountTransactions(accountIban);

		model.addAttribute("transactions", transactions);

		return "transactions";
	}

	@RequestMapping(value = "/opendeposit", method = RequestMethod.POST)
	public String openDeposit(@Valid Transaction transaction,
			@Valid Deposit deposit, BindingResult result, Principal principal) {

		if (result.hasErrors()) {
			return "invalidinput";
		}

		if (accountsService.exists(transaction.getRecipientIban())) {
			String recipientIban = null;
			while (true) {
				recipientIban = IbanGenerator.generateIban();
				if (!accountsService.exists(recipientIban)) {
					transaction.setRecipientIban(recipientIban);
					break;
				}
			}
		}

		if (transaction.getAmount() > transactionsService
				.getAmountForIban(transaction.getInitiatorIban())) {
			return "insufficientfunds";
		}

		String username = principal.getName();
		String depositIban = transaction.getRecipientIban();

		transaction.setDate(DateTime.getCurrentDate());
		transaction.setTime(DateTime.getCurrentTime());

		deposit.setUsername(username);
		deposit.setIban(depositIban);
		deposit.setStartDate(DateTime.getCurrentDate());
		deposit.setEndDate(DateTime.getDateAfter(deposit.getDuration()));

		if (deposit.getDuration() == THREE_MONTHS) {
			deposit.setInterest(THREE_MONTHS_INTEREST);
		} else {
			deposit.setInterest(TWELVE_MONTHS_INTEREST);
		}

		transactionsService.createDeposit(transaction, deposit);

		return "transfercompleted";
	}
}
