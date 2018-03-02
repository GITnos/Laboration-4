package lab5.State;
/**
 * 
 * @author samuelgraden
 * 
 */
public class Customer {
	static int counterID = 0;
	// Total number of customers that has visited the store in this Sim.
	static double arriveTime = 0;
	// Sum of all arrive times
	private int id;
	
	// Arrival times
	private double arrival;
	// Time it takes for this customer to reach the store.
	private double checkout;
	// Time it takes for this customer to checkout.
	private double gather;
	// Time it takes for this customer to gather their wares.
	
	public Customer(double dArrival, double dCheckout, double dGather) {
		this.id = counterID;
		this.arrival = dArrival + arriveTime;
		arriveTime =+ dArrival;
		
		this.gather = dGather;
		this.checkout = dCheckout;
		counterID++;	
	}
	
	public int getId() {
		return id;
	}
	public double getArrival() {
		return arrival;
	}
	public double getGather() {
		return gather;
	}
	public double getCheckout() {
		return checkout;
	}
	public double getAllTime() {
		// Returns the total time it took for this customer to go through the Sim.
		return this.arrival + this.gather + this.checkout;
		
	}
}
