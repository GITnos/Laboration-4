package lab5.Events;
import lab5.State.Customer;
import lab5.State.State;
import lab5.State.StateStore;
/**
 * 
 * @author samuelgraden
 *
 */
public class Event {

	private int id;

	public void run(StateStore state) {
		
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTime() {
		return 0;
	}
}
