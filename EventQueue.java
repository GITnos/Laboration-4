package lab5.Events;

import java.util.ArrayList;

import lab5.Sim;
/**
 * EventQueue holds every event and keeps them in chronological order.
 * @author samuelgraden
 *
 */
public class EventQueue {

	private ArrayList<Event> EventList = new ArrayList();

	public EventQueue() {
		EventList.add(0,new EventStart());

		//EventList.add(new EventEnd());

	}
	/**
	 * the event will be added in and sorted after its time.
	 * 
	 * @param e the Event which will be added
	 * @return true when is is done
	 */
	public boolean add(Event e) {

		for(int i = 1; i<this.EventList.size();i++) {
			Event event = this.EventList.get(i);
			Event before = this.EventList.get(i-1);
			Event next = this.EventList.get(i+1);
			
			double sumTime = event.getTime();
			double sumTimeBefore = before.getTime();
			double sumTimeNext = next.getTime();
			
			if((sumTime >= sumTimeBefore) && (sumTime <sumTimeNext)){
				this.EventList.add(i,e);
				return true;
			}
		}

		this.EventList.add(this.EventList.size(), e);
		return true;

	}
	/**
	 * 
	 * @return the next event in line and then removes it
	 */
	public Event next() {
		Event output = this.EventList.get(0);
		this.EventList.remove(0);
		return output;
	}
	/**
	 * checks if the next Event is the end
	 * @return
	 */
	public boolean isEnd() {
		if(this.EventList.get(0) instanceof EventEnd ) {
			return true;
		}
		else {
			return false;
		}
	}
}
