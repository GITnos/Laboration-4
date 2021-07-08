package lab5.Events;

import lab5.State.StateStore;
/**
 * EventCheckout 
 * @author Samuel Gradén, Tom Brander
 */
public class EventCheckout extends Event{
	private double time;
	private StateStore state;
	private double qtime = 0.0d;

	

	public EventCheckout(StateStore state,EventQueue EventQueue) {
		this.state = state;
		
		this.time = state.getCurrentTime()+state.getCheckout();
		qtime = this.time - state.getCurrentTime();
	}
	/**
	 * When running EventCheckout the Queue time for the customer will be calculated. 
	 * If there is another customer standing in queue its EventCheckout will be created.
	 * 
	 * @author Samuel Gradén, Tom Brander
	 */
	@Override
	public void run(StateStore state,EventQueue EventQueue) {		
		super.run(state, EventQueue);
		state.setCurrentTimte(this.getTime());
		if(state.size()>0) {
			// If there are customers queueing...
			int newID = state.first().getId();
			EventCheckout EC = new EventCheckout(state,EventQueue);
			EC.setId(newID);
			EventQueue.add(EC);
			state.decreseNumOfFreeCounter();
			state.removeFirst();
		}
		state.increseNumOfFreeCounter();
		state.removeCustomer();
	}
	@Override
	public String getName() {
		return "Checkout";
	}

	@Override
	public double getTime() {
		return this.time;
	}

}
