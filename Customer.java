package lab5.State;

/**
 * 
 * @author samuelgraden
 * 
 */
public class Customer {
	private int id;

	// Arrival times
	private double arrival;
	private double checkout;
	private double gather;

	public Customer(double dArrival, double dCheckout, double dGather, double dArriveTime, int iId) {
		this.id = iId;
		this.arrival = dArrival + dArriveTime;

		this.gather = dGather;
		this.checkout = dCheckout;
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
