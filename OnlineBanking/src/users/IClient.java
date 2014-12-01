package users;

import java.util.ArrayList;
import java.util.HashMap;

import products.BankProduct;

public interface IClient 
{
	public void transferMoney();
	public void openAccount();
	public void openDeposit();
	public HashMap<String, HashMap<String, ArrayList<BankProduct>>> getClientAccounts();
	public String getName();
	public String getIdNumber();
	public String getEmail();
	public String getPhone();
	public String getPassword();
	public Address getAddress();
	public void setName(String name);
	public void setIdNumber(String idNumber);
	public void setEmail(String email);
	public void setPhone(String phone);
	public void setPassword(String password);
	public void setAddress(String country, String city, String street, int postCode);
}
