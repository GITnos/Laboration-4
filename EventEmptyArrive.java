package lab5.Events;

import lab5.State.Customer;

public class EventEmptyArrive extends Event{
	
	@Override
	public void run(Customer customer) {
		EventQueue.EventList.add(new EventArrive());
	}

}
