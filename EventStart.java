package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;

public class EventStart extends Event{

	@Override
	public void run(StateStore state){
		EventQueue.add(new EventArrive(state));
	}
	
	@Override
	public double getTime() {
		return Integer.MIN_VALUE;
	}
}
