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
	//Lägg till att det skapas ett checkout event här med samma id.
	/**
	*run shall create the checkout event
	*/
	@Override
	public void run(StateStore state) {
		this.state = state;
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
