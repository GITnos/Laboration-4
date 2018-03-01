package lab5.State;

public class CreateCustomer {
	
	//public void CreateCustomer() {
		
	//}
	
	public Customer newCustomer(double dArrival, double dCheckout, double dGather) {
		return new Customer(dArrival, dCheckout,dGather);
	}
}

