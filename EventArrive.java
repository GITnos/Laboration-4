package lab5.Events;

import lab5.Sim;
import lab5.State.CreateCustomer;
import lab5.State.Customer;
import lab5.State.State;
import lab5.State.StateStore;
/**
 * EventArrive is the event which is runned when ever a new customer arrives,
 * @author samuelgraden
 *
 */
public class EventArrive extends Event{	
	/**
	 * the id is the same as the customer whom which this event belongs to
	 */
	private int id;
	StateStore state;
	
	/**
	 * When an EventArrive is created the customer is created, the customers id is attached to the event.
	 * @author samuelgraden
	 * @param state
	 */
	public EventArrive(StateStore state) {
		Customer customer = state.createCustomer();
		this.setId(customer.getId());
	}
	
	@Override
	/** run will create the next arrive if there is room for another customer, is will also create its own gatether event
	 * @param state
	 */
	public void run(StateStore state) {
		if(true) {
			if(state.getMaxCustomers()>= state.getCurrentCustomers()) {

				
				EventQueue.add(new EventArrive(state));
				EventGather EG = new EventGather();
				EG.setId(this.id);
				EventQueue.add(EG);

				//the store is full
			}else {
				EventQueue.add(new EventArrive(state));
				state.addMissedCustomer();

			}
		}
	}
	
	@Override
	/**
	 * returns the time of the corresponding customer arrive time
	 */
	public double getTime() {
		int id = this.getId();
		return this.state.getCustomer(this.id).getArrival();
	}
}
