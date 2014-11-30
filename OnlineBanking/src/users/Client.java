package users;

public abstract class Client extends User implements IClient
{

	Client(String name, String idNumber, String email, String phone,
			String password, String country, String city, String street, int postCode) 
	{
		super(name, idNumber, email, phone, password, country, city, street, postCode);
	}
	
	public void transferMoney()
	{
		
	}
	
	public void openDeposit()
	{
		
	}
}