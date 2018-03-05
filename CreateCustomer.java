package lab5.State;
/**
 * Creates customers and keeps track of their id
 * @author Samuel Gradén
 *
 */
public class CreateCustomer {
	
	private double arrivalSum = 0.0d;
	private int numCustomers = 0;
	/**
	 * 
	 * @param dArrival
	 * @param dCheckout
	 * @param dGather
	 * @return A Customer
	 */
	public Customer newCustomer(double dArrival, double dCheckout, double dGather) {
		this.arrivalSum += dArrival;
		Customer c = new Customer(arrivalSum, dCheckout, dGather, numCustomers);
		numCustomers++;
		return c;
	}
}
