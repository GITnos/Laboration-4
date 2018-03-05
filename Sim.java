package lab5;

import lab5.Events.EventQueue;
import lab5.State.StateStore;
/**
 * this creates a simulation
 * @author samuelgraden
 *
 */
public class Sim {
	private EventQueue eventQ;
	private StateStore state;

	public Sim(int numOfCounter){
		eventQ = new EventQueue();
		state = new StateStore((double) 0, (double) 0, (double) 0, numOfCounter);
	}

	public StateStore getState(){return state;}

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
