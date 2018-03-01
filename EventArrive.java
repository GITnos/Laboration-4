package lab5.Events;

import lab5.Sim;
import lab5.State.Customer;
import lab5.State.StateStore;

public class EventArrive extends Event{	
	
	@Override
  public void run(Customer customer) {
		super.run(customer);
		if(StateStore.getMaxCustomers()>=Sim.customerList.size()) {
			EventQueue.add(new EventArrive());
		}else {
			EventQueue.add(new EventEmptyArrive());
		}
		
		EventQueue.add(new EventGather());
	}
	
	@Override
	public double getTime() {
		int id = this.getId();
		return Sim.customerList.get(id).getArrival();
	}
}
