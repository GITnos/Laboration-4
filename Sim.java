package lab5;

import java.util.ArrayList;
import java.util.Observable;

import lab5.Events.EventQueue;
import lab5.Events.EventStart;
import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * this creates a simulation
 * @author samuelgraden
 */
public class Sim extends Observable{
	private EventQueue eventQ;
	private StateStore state;

	private final double dLower = 2.0;
	private final double dUpper = 3.0;
	private final double pLower = 0.5;
	private final double pUpper = 1.0;
	private final long seed = 1234;
	private final double dLambda = 1.0;
	private final int maxCust = 5;

	public Sim(int counters, long seed) {
		this.eventQ = new EventQueue();
		this.state = new StateStore(dLower,dUpper,pLower,pUpper,this.seed,dLambda,counters);
		state.setNumOfCounter(counters);
		state.setMaxCustomers(maxCust);
	}
	public Sim(int counters) {

		this.eventQ = new EventQueue();
		this.state = new StateStore(dLower,dUpper,pLower,pUpper,dLambda,counters);
		state.setNumOfCounter(counters);
		//System.out.println(2);
		state.setMaxCustomers(maxCust);

	}

	public StateStore getState(){
		return this.state;
	}

	public EventQueue getEventQueue() {
		return this.eventQ;
	}

	/**
	 * all of the event is run until the EventQueue is empty
	 */
	public void runSim() {

		//	eventQ.next().run(state, eventQ);
		while(!(eventQ.isEnd())){
			//System.out.println("Jag kör");
			//state.upView();
			eventQ.next().run(state,eventQ);
			//eventQ.sort();
			
			
			//System.out.println("Current Time: " + state.getCurrentTime());
			//System.out.println("Kassorna var lediga: "+ state.getFreeCounterTime());
		}
		//

	}


}
