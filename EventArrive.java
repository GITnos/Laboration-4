package lab5.Events;

import lab5.Sim;
import lab5.State.CreateCustomer;
import lab5.State.Customer;
import lab5.State.State;
import lab5.State.StateStore;

public class EventArrive extends Event{	

	private int id;
	StateStore state;
	public EventArrive(StateStore state) {
		Customer customer = state.createCustomer();
		this.setId(customer.getId());
	}
	@Override
	public void run(StateStore state) {
		if(true) {

			if(state.getMaxCustomers()>= state.getCurrentCustomers()) {

				
				EventQueue.add(new EventArrive(state));
				EventGather EG = new EventGather();
				EG.setId(this.id);
				EventQueue.add(EG);


			}else {
				EventQueue.add(new EventArrive(state));
				state.addMissedCustomer();

			}
		}
	}

	@Override
	public double getTime() {
		int id = this.getId();
		return this.state.getCustomer(this.id).getArrival();
	}
}
