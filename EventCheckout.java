package lab5.Events;

import lab5.State.StateStore;
/**
 * EventCheckout 
 * @author Samuel Gradén, Tom Brander
 */
public class EventCheckout extends Event{
	private double time;

	private StateStore state;

	public EventCheckout(StateStore state,EventQueue EventQueue) {
		
		//System.out.println("EventCheckout: Created id: " + this.getId());
		state.getCustomer(this.getId()).setQueueTime(state.getCurrentTime() - state.getCustomer(this.getId()).getArrival() -  state.getCustomer(this.getId()).getGather() );
		this.time = state.getCurrentTime() + state.getCustomer(this.getId()).getCheckout();
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
		
		
		super.run(state, EventQueue);
		
		
		//this.state = state;
		int id = this.getId();
		//state.getCustomer(id).setQueueTime(state.getCurrentTime() - (state.getCustomer(id).getArrival() + state.getCustomer(id).getGather()));
		//System.out.println("CurrentTime:" + state.getCurrentTime()+ " - " + (state.getCustomer(id).getArrival() + state.getCustomer(id).getGather()) + " = " + state.getCustomer(id).getQueueTime()+ " "+ id + "  Gather tiden: " + state.getCustomer(id).getGather()); 
		
		state.increseNumOfFreeCounter();
	//	System.out.println("Size: " + state.size());
		state.setCurrentTimte(this.getTime());
		if(state.size()>0) {
			
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
