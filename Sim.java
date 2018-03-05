package lab5;

import java.util.ArrayList;

import lab5.Events.EventQueue;
import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * this creates a simulation
 * @author samuelgraden
 *
 */
public class Sim {
	EventQueue eventQ = new EventQueue();
	StateStore state = new StateStore(0, 0, 0);

	//ArrayList<Customer> customerList;
	/**
	 * all of the event is runned until the EventQueue is empty
	 */
	public void runSim() {
		
		while(!(eventQ.isEnd())){
			
			eventQ.next().run(state,eventQ);
		}
		
	}
	
}
