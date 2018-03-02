package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;
import lab5.State.StateStore;

public class EventCheckout extends Event{
	private StateStore state;
	@Override
	public void run(StateStore state) {
		this.state = state;
	}
	
	@Override
	public double getTime() {
		int id = this.getId();
		return this.state.getCustomer(this.getId()).getArrival()+this.state.getCustomer(this.getId()).getGather();
	}

}
