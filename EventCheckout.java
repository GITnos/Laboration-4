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
		double checkoutTime = state.getCustomer(this.getId()).getCheckout();
		double gatherTime = state.getCustomer(this.getId()).getGather();
		double arriveTime = state.getCustomer(this.getId()).getArrival();
		//System.out.println("EventCheckout: Created id: " + this.getId());
	//	qtime = state.getCurrentTime() - state.getCustomer(this.getId()).getArrival() -  state.getCustomer(this.getId()).getGather();
		this.time = state.getCurrentTime() + state.getCustomer(this.getId()).getCheckout();
		qtime = time - checkoutTime - gatherTime - arriveTime;
		state.addqTime(qtime);
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
		int id = this.getId();
		state.increseNumOfFreeCounter();
		state.setCurrentTimte(this.getTime());
		state.addqTime(qtime);
		if(state.size()>0) {
			// If there are customers queueing...
			int newID = state.first().getId();
			EventCheckout EC = new EventCheckout(state,EventQueue);
			EC.setId(newID);
			EventQueue.add(EC);
			state.decreseNumOfFreeCounter();
			state.removeFirst();
		}
		//System.out.println("CurrentTime:" + state.getCurrentTime());
		
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
