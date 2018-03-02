package lab5.State;

public class CreateCustomer {
// Used to create all customers.
	
	public Customer newCustomer(double dArrival, double dCheckout, double dGather) {
		// Returns a new customer.
		return new Customer(dArrival, dCheckout,dGather);
	}
}
