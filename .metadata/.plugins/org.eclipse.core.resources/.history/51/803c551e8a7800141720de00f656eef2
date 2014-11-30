package users;

public abstract class User 
{
	private String name;
	private Address address;
	private String idNumber;
	private String email;
	private String phone;
	private String password;
	
	User(String name, String idNumber, String email, String phone, String password,
			String country, String city, String street, int postCode)
		{
			setName(name);
			setIdNumber(idNumber);
			setEmail(email);
			setPhone(phone);
			setPassword(password);
			this.address = new Address(country, city, street, postCode);
		}

	public String getName() 
	{
		return name;
	}

	public void setName(String name) 
	{
		this.name = name;
	}

	public String getIdNumber() 
	{
		return idNumber;
	}

	public void setIdNumber(String idNumber) 
	{
		this.idNumber = idNumber;
	}

	public String getEmail() 
	{
		return email;
	}

	public void setEmail(String email) 
	{
		this.email = email;
	}

	public String getPhone() 
	{
		return phone;
	}

	public void setPhone(String phone) 
	{
		this.phone = phone;
	}

	public String getPassword() 
	{
		return password;
	}

	public void setPassword(String password) 
	{
		this.password = password;
	}
	
	
}
