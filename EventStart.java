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
		this.setTime(0);
	}
	@Override
	/**
	 * runs EventStart
	 * @param StateStore, EventQueue
	 * @author Samuel Gradén
	 */
	public void run(StateStore state,EventQueue EventQueue){
		
		super.run(state, EventQueue);
		
		EventQueue.add(new EventArrive(state));
		EventClose EC = new EventClose(state,EventQueue);
		EventQueue.add(EC);
		EventEnd EE = new EventEnd();
		EventQueue.add(EE);
		
		
	}
	@Override
	public String getName() {
		return "Start";
	}
	
}
