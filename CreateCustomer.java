package lab5.state;

public class CreateCustomer {
	
	public void CreateCustomer(int n) {
		for(int i = 0; i <= n; i++) {
			Customer a = new Customer(i);	
		}
		}
}

