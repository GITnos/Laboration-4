package lab5.state;

public class CreateCustomer {
	
	public void CreateCustomer(int n) {
		for(int i = 1; i <= n; i++) {
			Customer a = new Customer(i);	
		}
		}
}

