package users;

public abstract class Employee extends User
{

	Employee(String name, String idNumber, String email, String phone,
			String password, String country, String city, String street, int postCode) 
	{
		super(name, idNumber, email, phone, password, country, city, street, postCode);
	}

}