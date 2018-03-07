package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventArrive is the event which is runned when ever a new customer arrives,
 * @author Samuel Gradén, Tom Brander
 *
 */
public class EventArrive extends Event{	
	
	StateStore state;
	
	/**
	 * When an EventArrive is created the customer is created, the customers id is attached to the event.
	 * @author Samuel Gradén
	 * @param state
	 */
	public EventArrive(StateStore state) {
		//System.out.println("EventArrive: Creating...");
		//System.out.println("=========================================================");
		Customer customer = state.createCustomer();
		
		this.state = state;
		this.setId(customer.getId());
		//System.out.println("EventArrive: Created id: " + this.getId());
	}
	
	@Override
	/** run will create the next arrive if there is room for another customer, is will also create its own gatether event
	 * @param StateStore EventQueue
	 * @author Samuel Gradén, Tom Brander
	 */
	public void run(StateStore state,EventQueue EventQueue) {
		
		//System.out.println(this.state.getCustomer(this.getId()).getArrival());
		state.setCurrentTimte(this.getTime());
		super.run(state, EventQueue);
		//System.out.println("EventArrive: runs, with id: "+  this.getId());
		
		if(state.getCurrentTime()<state.getCloseTime()) {
			
			if(state.getMaxCustomers()>= state.getCurrentCustomers()) {
				state.addCustomer();
				//System.out.println("HALLLLLLÅÅÅÅ!!!!!");
				EventQueue.add(new EventArrive(state));
				EventGather EG = new EventGather(state);
				EG.setId(this.getId());
				//System.out.println("EventGather sets id: " + this.getId());
				EventQueue.add(EG);
				//state.addCustomer();

			//the store is full
			}else {
				//System.out.println("Butiken är full");
				EventQueue.add(new EventArrive(state));
				state.addMissedCustomer();

			}
		
		}else {
			//System.out.println("Affären stänger;");
			state.addMissedCustomer();
			//EventClose EClose = new EventClose(state, EventQueue);
			//EventQueue.add(EClose);
		}
	}
	@Override
	public String getName() {
		return "Arrive";
	}
	
	@Override
	/**
	 * @return the time of the corresponding customer arrive time
	 */
	public double getTime() {
		return this.state.getCustomer(this.getId()).getArrival();
	}
}
