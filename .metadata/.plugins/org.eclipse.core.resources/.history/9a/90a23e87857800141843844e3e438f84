package Users;

public abstract class User 
{
	private String name;
	private Address address;
	private int idNumber;
	private String email;
	private String phone;
	private String password;
	
	User(String name, int idNumber, String email, String phone, String password,
			String country, String city, String street, int postCode)
		{
			this.name = name;
			this.idNumber = idNumber;
			this.email = email;
			this.phone = phone;
			this.password = password;
			Address address = new Address(country, city, street, postCode);
		}
}
