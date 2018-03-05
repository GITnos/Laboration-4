package lab5.Events;

import lab5.State.StateStore;

/**
 * EventGather is the time is takes to gather weares
 * 
 * @author Samuel Gradén
 *
 */
public class EventGather extends Event {

	private StateStore state;

	/**
	 * the constructor of EventGather stores the state
	 * 
	 * @author Samuel Gradén
	 * @param state
	 */
	public EventGather(StateStore state) {
		System.out.println("EventGather: Creating... \nEventGather: Created id:" + this.getId());
		this.state = state;
	}

	@Override
	/**
	 * @author Samuel Gradén
	 */
	public void run(StateStore state, EventQueue EventQueue) {
		System.out.println("EventGather runs, id:" + this.getId());
		super.run(state, EventQueue);
		this.state = state;

		if (state.getNumOfFreeCounter() > 0) {
			EventCheckout EC = new EventCheckout(state, EventQueue);
			EC.setId(this.getId());
			EventQueue.add(EC);
			

		} else {
			
		}
		state.add(state.getCustomer(this.getId()));
	}

	@Override
	public double getTime() {
		return this.state.getCustomer(this.getId()).getArrival();
	}

}
