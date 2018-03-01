package lab5.Events;

import lab5.State.Customer;

public class EventStart extends Event{

	@Override
	public void run(Customer customer){
		EventQueue.add(new EventArrive());
	}
	
	@Override
	public double getTime() {
		return Integer.MIN_VALUE;
	}
}
