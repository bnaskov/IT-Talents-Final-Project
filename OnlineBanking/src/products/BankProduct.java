package products;

public abstract class BankProduct implements IBankProduct{

	private String name;
	private double value;
	private Type type;
	
	public BankProduct(String name, double value, Type type) {
		setName(name);
		setType(type);
		setValue(value);
	}
	
	public void setName(String name)     {		this.name = name;	  }
	public void setValue(double value) {		this.value = value;  }
	public void setType(Type type)       {		this.type = type;	  }

	public String getName() {
		return this.name;
	}

	public Double getValue() {
		return this.value;
	}

	public Type getType() {
		return this.type;
	}
	


	
}



