package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventCheckout 
 * @author samuelgraden
 *
 */
public class EventCheckout extends Event{
	private double time;
	
	private StateStore state;
	
	public EventCheckout(StateStore state,EventQueue EventQueue) {
		 
		this.time = state.getCurrentTime();
		
	}
	
	@Override
	public void run(StateStore state,EventQueue EventQueue) {
		super.run(state, EventQueue);
		this.state = state;
		int id = this.getId();
		state.getCustomer(id).setQueueTime(state.getCurrentTime() - (state.getCustomer(id).getArrival() + state.getCustomer(id).getGather()));
		
		int newID = state.first().getId();
		EventCheckout EC = new EventCheckout(state,EventQueue);
		EC.setId(newID);
		EventQueue.add(EC);
		
		
		state.removeFirst();
	}
	/**
	 * return the time when the customer is supposed to START checking out.
	 */
	@Override
	public double getTime() {
		return this.time;
		
		//return this.state.getCustomer(this.getId()).getArrival()+this.state.getCustomer(this.getId()).getGather();
	}

}
