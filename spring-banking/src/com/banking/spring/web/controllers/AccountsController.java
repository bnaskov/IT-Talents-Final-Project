package com.banking.spring.web.controllers;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.banking.spring.web.dao.Account;
import com.banking.spring.web.service.AccountsService;

@Controller
public class AccountsController {

	private AccountsService accountsService;

	@Autowired
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@RequestMapping("/bankaccounts")
	public String showAccounts(Model model, Principal principal) {

		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "bankaccounts";
	}

	/*
	 * Move it to AccountsController
	 */
	@RequestMapping("/openbankaccount")
	public String openBankAccount() {
		return "openbankaccount";
	}

	@RequestMapping("/transfermoneytouser")
	public String transferMoneyToUser() {
		return "transfermoneytouser";
	}

	@RequestMapping(value = "/paybills", method = RequestMethod.GET)
	public String payBills(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "paybills";
	}
}
