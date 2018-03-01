package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;

public class EventGather extends Event{
	
	@Override
	public void run(Customer customer) {
		
	}
	
	@Override
	public double getTime() {
		int id = this.getId();
		return Sim.customerList.get(id).getGather();
	}

}
