package lab5.Events;

import lab5.State.StateStore;
/**
 * EventCheckout 
 * @author Samuel Gradén
 */
public class EventCheckout extends Event{
	private double time;
	
	private StateStore state;
	
	public EventCheckout(StateStore state,EventQueue EventQueue) {
		this.time = state.getCurrentTime();
		System.out.println("EventCheckout: Created id: " + this.getId());
		this.state = state;
	}
	/**
	 * When running EventCheckout the Queue time for the customer will be calculated. 
	 * If there is another customer standing in queue its EventCheckout will be created.
	 * 
	 * @author Samuel Gradén, Tom Brander
	 */
	@Override
	public void run(StateStore state,EventQueue EventQueue) {
		
		System.out.println("EventCheckout runs id: " + this.getId());
		super.run(state, EventQueue);
		//this.state = state;
		int id = this.getId();
		state.getCustomer(id).setQueueTime(state.getCurrentTime() - (state.getCustomer(id).getArrival() + state.getCustomer(id).getGather()));
		
		state.removeFirst();
		
		if(state.size()>0) {
			int newID = state.first().getId();
			EventCheckout EC = new EventCheckout(state,EventQueue);
			EC.setId(newID);
			EventQueue.add(EC);
		}
		
	}
	@Override
	public double getTime() {
		return this.time;
		
	}

}
