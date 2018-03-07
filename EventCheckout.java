package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventClose shall be runned when the store is closed, this will prohibit further customers to ARRIVE.
 * @author Samuel Graden, Tom Brander
 *
 */
public class EventClose extends Event{
	private double time;
	/**
	 *
	 * @author Samuel Gradén
	 * @param state
	 * @param EventQueue
	 */
	public EventClose(StateStore state, EventQueue EventQueue) {
		this.time = state.getCloseTime();
		
	}
	/**
	 * When running EventClose, the EventEnd is created. 
	 * @author Samuel Gradén, Tom Brander
	 */
	@Override
	public void run(StateStore state,EventQueue EventQueue) {
		state.setCurrentTimte(this.getTime());
		super.run(state, EventQueue);
		
		EventEnd EE = new EventEnd();
		EventQueue.add(EE);
	}
	
	@Override
	public String getName() {
		return "Close";
	}
	
	@Override
	public double getTime() {
		return this.time;
	}
}
