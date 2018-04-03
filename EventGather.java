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
	private double time = 0.0d;

	/**
	 * The constructor of EventGather
	 * 
	 * @author Samuel Gradén
	 * @param state
	 */
	public EventGather(StateStore state) {
		this.state = state;
		time = state.getCurrentTime() + state.getGather();
	}

	@Override
	public void run(StateStore state, EventQueue EventQueue) {
		state.setCurrentTimte(getTime());
		super.run(state, EventQueue);
		this.state = state;
		if (state.getNumOfFreeCounter() > 0) {
			//  if there are any free counters...
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
		return time;
	}

}
