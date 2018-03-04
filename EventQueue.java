package lab5.Events;

import java.util.ArrayList;

import lab5.Sim;
/**
 * EventQueue holds every event and keeps them in chronological order.
 * @author samuelgraden
 *
 */
public class EventQueue {

	public static ArrayList<Event> EventList = new ArrayList();

	public void EventQueue() {
		EventList.add(0,new EventStart());

		//EventList.add(new EventEnd());

	}
	/**
	 * the event will be added in and sorted after its time.
	 * 
	 * @param e the Event which will be added
	 * @return true when is is done
	 */
	public static boolean add(Event e) {

		for(int i = 1; i<EventList.size();i++) {
			Event event = EventList.get(i);
			Event before = EventList.get(i-1);
			Event next = EventList.get(i+1);
			
			double sumTime = event.getTime();
			double sumTimeBefore = before.getTime();
			double sumTimeNext = next.getTime();
			
			if((sumTime >= sumTimeBefore) && (sumTime <sumTimeNext)){
				EventList.add(i,e);
				return true;
			}
		}

		EventList.add(EventList.size(), e);
		return true;

	}
	/**
	 * 
	 * @return the next event in line and then removes it
	 */
	public Event next() {
		Event output = EventList.get(0);
		EventList.remove(0);
		return output;
	}
}
