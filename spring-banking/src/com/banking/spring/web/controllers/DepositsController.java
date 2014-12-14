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
public class DepositsController {

	private AccountsService accountsService;
	private DepositsService depositsService;

	@Autowired
	public void setAccountsService(AccountsService accountsService) {
		this.accountsService = accountsService;
	}

	@Autowired
	public void setDepositsService(DepositsService depositsService) {
		this.depositsService = depositsService;
	}

	@RequestMapping(value = "/opendeposit", method = RequestMethod.GET)
	public String openDeposit(Model model, Principal principal) {
		String username = principal.getName();

		List<Account> accounts = accountsService.getAccounts(username);

		model.addAttribute("accounts", accounts);

		return "opendeposit";
	}

	@RequestMapping("/deposits")
	public String showDeposits(Model model, Principal principal) {

		String username = principal.getName();

		List<Deposit> deposits = depositsService.getDeposits(username);

		model.addAttribute("deposits", deposits);

		return "deposits";
	}

}
