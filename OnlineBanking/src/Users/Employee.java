package Users;

public class Employee extends User
{

	Employee(String name, int idNumber, String email, String phone,
			String password, String country, String city, String street, int postCode) 
	{
		super(name, idNumber, email, phone, password, country, city, street, postCode);
	}

}
