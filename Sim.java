package lab5;

import java.util.ArrayList;

import lab5.Events.EventQueue;
import lab5.State.Customer;
import lab5.State.StateStore;

public class Sim {
	EventQueue eventQ = new EventQueue();
	StateStore state = new StateStore(0, 0, 0);

	public static ArrayList<Customer> customerList;
	
	public void runSim() {
		
		for(int i = 0; i<eventQ.EventList.size();i++) {
			
			eventQ.next().run(state.createCustomer());
		}
	}
	
}
