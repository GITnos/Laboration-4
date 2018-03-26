package lab5.Events;

import lab5.State.StateStore;

/**
 * EventGather is the time is takes to gather wares
 * 
 * @author Samuel Gradén
 *
 */
public class EventGather extends Event {

	private StateStore state;

	/**
	 * The constructor of EventGather
	 * 
	 * @author Samuel Gradén
	 * @param state
	 */
	public EventGather(StateStore state) {
		this.state = state;
	}

	@Override
	public void run(StateStore state, EventQueue EventQueue) {
		state.setCurrentTimte(getTime());
		super.run(state, EventQueue);
		this.state = state;
		if (state.getNumOfFreeCounter() > 0) {
			EventCheckout EC = new EventCheckout(state, EventQueue);
			EC.setId(this.getId());
			EventQueue.add(EC);
			state.decreseNumOfFreeCounter();
		} else {
			// add customer with the same id to the fifo queue 
			state.add(state.getCustomer(this.getId()));
		}
		
	}
	
	@Override
	public String getName() {
		return "Gather";
	}

	@Override
	public double getTime() {
		// Returns arrive + gather time of customer with the same id
		return this.state.getCustomer(this.getId()).getArrival() + this.state.getCustomer(this.getId()).getGather();
	}

}
