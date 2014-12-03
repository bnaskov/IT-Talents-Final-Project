package users;

public class Manager extends Employee
{

	Manager(String name, String idNumber, String email, String phone,
			String password, String country, String city, String street, int postCode) 
	{
		super(name, idNumber, email, phone, password, country, city, street, postCode);
	}
	
	public void checkAccount(String iban)
	{
		
	}
	
	public void checkClient(String clientIdNumber)
	{
		
	}
	
	public void checkAllAccounts()
	{
		
	}
}
