package lab5.State;

public class Customer {
	static private int idCounter =1;
	private int id;
	
	private int arrival;
	private int gather;
	private int checkout;
	
	Time time;
	
	public Customer(int id) {
		idCounter++;
		this.id = id;
		this.arrival = State.arrival();
		this.gather = State.gather();
		this.checkout = State.gather();
		
		
	}
	public int getidCounter() {
		return idCounter;
	}
}
