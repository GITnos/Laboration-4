package lab5.State;

public class CreateCustomer {
// Used to create all customers.
	
	private int numCustomers = 0;
	// Total number of customers.
	
	public Customer newCustomer(double dArrival, double dCheckout, double dGather, double dTravelTime) {
		Customer c = new Customer(dArrival, dCheckout, dGather, numCustomers);
		numCustomers++;
		// Returns a new customer.
		return c;
	}
}
