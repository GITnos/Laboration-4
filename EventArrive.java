package lab5.Event;

import lab5.State.StateStore;

public class EventArrive extends Event{

	
	@Override
	public void run() {
		
		StateStore.createCustomer()
		
		EventArrive eA = new EventArrive();
		
		eA.setID();
		
		EventQueue.add(new EventArrive());
		EventQueue.add(new EventGather());
		EventQueue.add(new EventCheckout());
		
		
	}
	
}
