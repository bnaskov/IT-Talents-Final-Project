package users;

public abstract class Employee extends User {

	Employee(String name, String idNumber, String email, String phone,
			String password, String city, String street) {
		super(name, idNumber, email, phone, password, city, street);
	}

}
