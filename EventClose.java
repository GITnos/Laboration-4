package lab5.Events;

import lab5.State.Customer;

public class EventClose extends Event{

	@Override
	public void run(Customer customer) {
		
	}
	
	@Override
	public double getTime() {
		return Integer.MAX_VALUE;
	}
}
