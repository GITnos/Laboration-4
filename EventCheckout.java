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
	private StateStore state;
	@Override
	public void run(StateStore state) {
		this.state = state;
	}
	/**
	 * return the time when the customer is supposed to START checking out.
	 */
	@Override
	public double getTime() {
		int id = this.getId();
		return this.state.getCustomer(this.getId()).getArrival()+this.state.getCustomer(this.getId()).getGather();
	}

}
