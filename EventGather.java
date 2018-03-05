package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventGather is the time is takes to gather weares
 * @author samuelgraden
 *
 */

public class EventGather extends Event{
	
	private StateStore state;
	
	@Override
	public void run(StateStore state,EventQueue EventQueue) {
		super.run(state, EventQueue);
		this.state = state;
		if(state.getNumOfFreeCounter() >0) {
			EventCheckout EC = new EventCheckout(state,EventQueue);
			EC.setId(this.getId());
		}else{
			state.add(state.getCustomer(this.getId()));
		}
	}

	@Override
	/**
	 * returns when the customer shall begin gather.
	 */
	public double getTime() {
		int id = this.getId();
		return this.state.getCustomer(this.getId()).getArrival();
	}

}
