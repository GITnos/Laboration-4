package lab5.Events;
import java.util.Observable;

import lab5.State.StateStore;
/**
 * This class is the general description of an event, all other events build up upon this one
 * @author samuelgraden
 *
 */
public class Event extends Observable{

	private int id;
	/**
	 * 
	 * Every event has a run method which is run by the simulation, run will also update the current time
	 * @param
	 * @author Samuel Gradén, Tom Brander
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
	/**
	 * 
	 * @return the time when this event shall start
	 * @author Samuel Gradén
	 */
	public double getTime() {
		return 0;
	}
}
