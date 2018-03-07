package lab5.Events;

import lab5.State.Customer;
import lab5.State.StateStore;
/**
 * EventEnd is the last event which will be run this will be the benchmark for the summary which will be printed out at the end
 * @author Samuel Gradén
 *
 */
public class EventEnd extends Event{

	@Override
	public void run(StateStore state,EventQueue EventQueue){
		super.run(state, EventQueue);
		//System.out.println("Simulering är avslutad");
	}
	
	@Override
	public String getName() {
		return "End";
	}
	/**
	 * The time is max so it always will be the last.
	 */
	@Override
	public double getTime() {
		return Integer.MAX_VALUE;
	}

}
