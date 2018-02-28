package lab5.State;

public class Customer {
	private int id;
	
	private int arrival;
	private int gather;
	private int checkout;
	
	public Customer(int id,Time time) {
		
		this.id = id;
		this.arrival = time.arrival();
		this.gather = time.gather();
		this.checkout = time.gather;
		
		
	}
}
