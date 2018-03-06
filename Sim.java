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

	//deklarera alla parametrar
	
	
	
	StateStore state;
	EventQueue eventQ;
	public Sim(double dLower, double dUpper,double pLower, double pUpper, long seed, double dLambda,int counters,int maxCust) {

		this.eventQ = new EventQueue();
		this.state = new StateStore(dLower,dUpper,pLower,pUpper,seed,dLambda);
		state.setNumOfCounter(counters);
		state.setMaxCustomers(maxCust);
	}
	public Sim(double dLower, double dUpper,double pLower, double pUpper, double dLambda,int counters,int maxCust) {

		this.eventQ = new EventQueue();
		this.state = new StateStore(dLower,dUpper,pLower,pUpper,dLambda);
		state.setNumOfCounter(counters);
		state.setMaxCustomers(maxCust);
		
	}


	//ArrayList<Customer> customerList;
	/**
	 * all of the event is runned until the EventQueue is empty
	 */
	public void runSim() {
		
		while(!(eventQ.isEnd())){
			//System.out.println("Jag kör");
			eventQ.next().run(state,eventQ);
		}

	}

}
