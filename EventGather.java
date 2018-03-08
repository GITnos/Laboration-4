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
	public EventGather(StateStore state,int id) {
	
		//System.out.println("=========================================================");
		this.state = state;
		double time = state.getCustomer(this.getId()).getArrival() + state.getCustomer(this.getId()).getGather();
		this.setTime(time);

	}
	/**
	 * @author Samuel Gradén
	 */
	@Override
	public void run(StateStore state, EventQueue EventQueue) {
	
		super.run(state, EventQueue);
		
		
		state.setCurrentTimte(getTime());
		//System.out.println("EventGather runs, id:" + this.getId());

		this.state = state;
	
		if (state.getNumOfFreeCounter() > 0) {
			EventCheckout EC = new EventCheckout(state, EventQueue);
			EC.setId(this.getId());
			EventQueue.add(EC);
			state.decreseNumOfFreeCounter();
			

		} else {
			state.add(state.getCustomer(this.getId()));
		}
		
		
		
	}
	
	@Override
	public String getName() {
		return "Gather";
	}

	@Override
	public double getTime() {
		return this.state.getCustomer(this.getId()).getArrival() + this.state.getCustomer(this.getId()).getGather();
	}

}
