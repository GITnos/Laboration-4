package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;

/**
 * Event start is the first event and represents the opening of the store and it creates the first arrive event.
 * @author samuelgraden
 *
 */
public class EventStart extends Event{
	public EventStart() {
		System.out.println("EventStart: Created");
	}
	@Override
	/**
	 * runs EventStart
	 * @param StateStore, EventQueue
	 */
	public void run(StateStore state,EventQueue EventQueue){
		System.out.println("EventStart: Run");
		super.run(state, EventQueue);
		EventQueue.add(new EventArrive(state));
	}
	
	@Override
	/**
	 * getTime 
	 * @return the time 0 to represent the start
	 */
	public double getTime() {
		return 0;
	}
}
