package lab5.State;

public class Customer {
	private int id;
	
	private int arrival;
	private int gather;
	private int checkout;
	
	Time time;
	
	public Customer(int id) {
		
		this.id = id;
		this.arrival = State.arrival();
		this.gather = State.gather();
		this.checkout = State.gather();
		
		
	}
}
