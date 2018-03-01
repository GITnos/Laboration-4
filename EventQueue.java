package lab5.Events;

import java.util.ArrayList;

public class EventQueue {

	static ArrayList<Event> EventList = new ArrayList();

	public EventQueue() {
		EventList.add(0,new EventStart());

		//EventList.add(new EventEnd());

	}

	public static boolean add(Event e) {

		for(int i = 1; i<EventList.size();i++) {
			Event event = EventList.get(i);
			Event before = EventList.get(i-1);
			Event next = EventList.get(i+1);
			
			double sumTime = event.getTime();
			double sumTimeBefore = before.getTime();
			double sumTimeNext = next.getTime();
			
			if((sumTime >= sumTimeBefore) && (sumTime <=sumTimeNext)){
				EventList.add(i,e);
				return true;
			}
		}

		EventList.add(EventList.size(), e);
		return true;

	}
}
