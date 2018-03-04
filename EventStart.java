package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;

/**
 * Event start is the first event and represents the opening of the store and it creates the first arrive event.
 * @author samuelgraden
 *
 */
public class EventStart extends Event{
	@Override
	/**
	 * EventStart is runned
	 */
	public void run(StateStore state){
		EventQueue.add(new EventArrive(state));
	}
	
	@Override
	/**
	 * getTime return the time 0 to represent the start
	 */
	public double getTime() {
		return 0;
	}
}
