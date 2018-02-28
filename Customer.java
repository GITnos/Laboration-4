package lab5.State;
/**
 * 
 * @author samuelgraden
 *
 */
public class Customer {
	static private int idCounter =1;
	private int id;

	private int arrival;
	private int gather;
	private int checkout;
	
	private Time time;
	
	public Customer(int id) {
		idCounter++;
		this.id = id;
		this.arrival = State.arrival();
		this.gather = State.gather();
		this.checkout = State.gather();
		
		
	}
	
	public static int getIdCounter() {
		return idCounter;
	}
	public int getId() {
		return id;
	}
	public int getArrival() {
		return arrival;
	}
	public int getGather() {
		return gather;
	}
	public int getCheckout() {
		return checkout;
	}
	public Time getTime() {
		return time;
	}
}
