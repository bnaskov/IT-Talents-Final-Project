package com.banking.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.spring.web.dao.Account;
import com.banking.spring.web.dao.Deposit;
import com.banking.spring.web.service.AccountsService;
import com.banking.spring.web.service.DepositsService;

@Controller
public class AccountsController {

	private AccountsService accountsService;
	private DepositsService depositService;

	@Autowired
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@Autowired
	public void setDepositService(DepositsService depositService) {
		this.depositService = depositService;
	}

	@RequestMapping("/bankaccounts")
	public String showAccounts(Model model, Principal principal) {

		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);
		List<Deposit> deposits = depositService.getDeposits(username);

		model.addAttribute("accounts", accounts);
		model.addAttribute("deposits", deposits);

		return "bankaccounts";
	}

	@RequestMapping(value = "/openbankaccount", method = RequestMethod.GET)
	public String openBankAccount(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "openbankaccount";
	}

	@RequestMapping(value = "/transfermoneytouser", method = RequestMethod.GET)
	public String transferMoneyToUser(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "transfermoneytouser";
	}

	@RequestMapping(value = "/paybills", method = RequestMethod.GET)
	public String payBills(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "paybills";
	}

	@RequestMapping(value = "/transactions", method = RequestMethod.GET)
	public String getTransactions(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "transactions";
	}

}
