package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;

public class EventArrive extends Event{	
	@Override
  public void run(Customer customer) {
		super.run(customer);
		EventQueue.add(new EventArrive());
		EventQueue.add(new EventGather());
	}
	
	@Override
	public double getTime() {
		int id = this.getId();
		return Sim.customerList.get(id).getArrival();
	}
}
