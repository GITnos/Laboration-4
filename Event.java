package lab5.Events;
import java.util.Observable;

import lab5.State.Customer;
import lab5.State.State;
import lab5.State.StateStore;
/**
 * This class is the general description of an event, all other events build up upon this one
 * @author samuelgraden
 *
 */
public class Event extends Observable{

	private int id;
	/**
	 * All event have a run method which is runned by the simulation
	 * @param state
	 */
	public void run(StateStore state, EventQueue EventQueue) {
		state.setFreeCounterTime((state.getCurrentTime()-state.getLastCheckedTime())*state.getNumOfFreeCounter());
		state.setLastCheckedTime(state.getCurrentTime());
		setChanged();
		notifyObservers();
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public double getTime() {
		return 0;
	}
}
