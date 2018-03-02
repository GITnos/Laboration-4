package lab5.State;

public class CreateCustomer {
// Used to create all customers.
	
	private double arrivalSum = 0.0d;
	private int numCustomers = 0;
	// Total number of customers.
	
	public Customer newCustomer(double dArrival, double dCheckout, double dGather) {
		this.arrivalSum += dArrival;
		Customer c = new Customer(arrivalSum, dCheckout, dGather, numCustomers);
		numCustomers++;
		// Returns a new customer.
		return c;
	}
}
