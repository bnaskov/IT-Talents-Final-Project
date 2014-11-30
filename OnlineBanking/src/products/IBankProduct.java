package products;


public interface IBankProduct {

	enum Type { CURRENT_ACCOUNT, DEPOSIT }
	String getName();
	Double getValue();
	Type getType();
	
	
}

