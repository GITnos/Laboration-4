package lab5.State;

/**
 * Represents a customer for the store,
 * @author Samuel Graden
 * 
 */
public class Customer {
	private int id;
	/**
	 * arrival is the time it takes from the opening of the store to the customer to arrive.
	 */

	public Customer(int iId) {
		this.id = iId;
		//System.out.println("Customer created with id: " + this.id);
	}

	public int getId() {
		return id;
	}
	
}
