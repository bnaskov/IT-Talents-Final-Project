package demo;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;
import products.accounts.DepositShortTerm;

public class Demo {

	public static void main(String[] args) {

		HashMap<String, HashMap<String, ArrayList<BankProduct>>> accounts = new HashMap() {
			{
				put("Deposit", new HashMap() {
					{
						put("ShortTermDeposit", new ArrayList<BankProduct>() {
							{
								add(new DepositShortTerm(10000));
							}
						});
					}
				});
			}
		};

		System.out.println(accounts.get("Deposit").get("ShortTermDeposit"));
		////////////////testing...........
	}
}
