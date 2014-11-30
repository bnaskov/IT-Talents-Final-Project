package users;

public class Address 
{
	private String country;
	private String city;
	private String street;
	private int postCode;
	
	Address(String country, String city, String street, int postCode)
	{
		setCountry(country);
		setCity(city);
		setStreet(street);
		setPostCode(postCode);
	}

	public String getCountry() 
	{
		return country;
	}

	public void setCountry(String country) 
	{
		this.country = country;
	}

	public String getCity() 
	{
		return city;
	}

	public void setCity(String city) 
	{
		this.city = city;
	}

	public String getStreet() 
	{
		return street;
	}

	public void setStreet(String street) 
	{
		this.street = street;
	}

	public int getPostCode() 
	{
		return postCode;
	}

	public void setPostCode(int postCode) 
	{
		this.postCode = postCode;
	}
	
	
}