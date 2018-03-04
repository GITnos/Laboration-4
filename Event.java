package lab5.Events;
import lab5.State.Customer;
import lab5.State.State;
import lab5.State.StateStore;
/**
 * This class is the general description of an event, all other events build up upon this one
 * @author samuelgraden
 *
 */
public class Event {

	private int id;
	/**
	 * All event have a run method which is runned by the simulation
	 * @param state
	 */
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
