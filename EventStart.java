package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;

/**
 * Event start is the first event and represents the opening of the store and it creates the first arrive event.
 * @author Samuel Graden
 *
 */
public class EventStart extends Event{
	public EventStart() {
		//System.out.println("EventStart: Created");
	}
	@Override
	/**
	 * runs EventStart
	 * @param StateStore, EventQueue
	 * @author Samuel Gradén
	 */
	public void run(StateStore state,EventQueue EventQueue){
		//System.out.println("EventStart: Run");
		super.run(state, EventQueue);
		EventQueue.add(new EventArrive(state));
	}
	@Override
	public String getName() {
		return "Start";
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
