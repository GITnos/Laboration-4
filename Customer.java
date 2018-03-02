package lab5.State;

/**
 * 
 * @author samuelgraden
 * 
 */
public class Customer {
	static int counterID = 0;
	static double arriveTime = 0;
	private int id;

	// Arrival times
	private double arrival;
	private double checkout;
	private double gather;

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

		return this.arrival + this.gather + this.checkout;

	}
}
