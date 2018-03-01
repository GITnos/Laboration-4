package lab5.Event;

import java.util.ArrayList;

public class EventQueue {

	static ArrayList<Event> EventList = new ArrayList();
	
	public void EventQueue() {
		EventList.add(0,new EventStart());
		
		//EventList.add(new EventEnd());
		
	}
	
	public static void add(Event e) {
		
		
		for(int i = 1; i<EventList.size();i++) {
			
		}
	
		
		
		
		
		
		EventList.add(index, e);
		
	}
}
