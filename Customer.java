package lab5.State;

/**
 * Represents a customer for the store,
 * @author Samuel Graden
 * 
 */
public class Customer {
	private int id;
	private double queueTime = 0;
	/**
	 * arrival is the time it takes from the opening of the store to the customer to arrive.
	 */
	private double arrival;
	
	private double checkout;
	private double gather;

	public Customer(double dArrival, double dCheckout, double dGather, int iId) {
		this.id = iId;
		this.arrival = dArrival;
		this.gather = dGather;
		this.checkout = dCheckout;
		//System.out.println("Customer created with id: " + this.id);
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
	public double getQueueTime() {
		return this.queueTime;
	}
	public void setQueueTime(double time) {
		this.queueTime = time;
	}
}
