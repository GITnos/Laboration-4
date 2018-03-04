package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventClose shall be runned when the store is closed, this will prohibit further customers to ARRIVE.
 * @author samuelgraden
 *
 */
public class EventClose extends Event{
	
	@Override
	public void run(StateStore state) {
		
	}
	//denna tiden är inte rätt den måste räknas ut utifrån current time och ska vara stängings tiden
	@Override
	public double getTime() {
		return Integer.MAX_VALUE-1;
	}
}
