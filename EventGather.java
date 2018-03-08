package lab5.Events;

import java.util.ArrayList;
import java.util.Observable;


/**
 * EventQueue holds every event and keeps them in chronological order.
 * 
 * @author Samuel Gradén, Tom Brander
 *
 */
public class EventQueue{

	private ArrayList<Event> EventList = new ArrayList<Event>();
	/**
	 * When EventQueue is created the start event; EventStart is created
	 * @author Samuel Gradén
	 */
	public EventQueue() {
		EventList.add(0, new EventStart());

		EventList.add(new EventEnd());
	}

	/**
	 * The event will be added in and sorted after its time.
	 * @author Samuel Gradén, Tom Brander
	 * @param 
	 * @return True when is is done
	 */
	public boolean add(Event e) {
		if(EventList.size()==0) {
			EventList.add(e);
			return true;
		}
		for(int i = 0; i<EventList.size();i++) {
			if(e.getTime()<EventList.get(i).getTime()) {
				EventList.add(i,e);
				return true;
			}
		}
		EventList.add(EventList.size()-1,e);
		return true;

	}

	public void srt() {
		//boolean isSorted = false;
		int size = EventList.size();
		for(int j = size-1; j>0;j--) {
			for(int i=0;i<j-1;i++) {
				Event temp = EventList.get(size-1);
				EventList.remove(size-1);
				EventList.add(temp);

			}

		}
	}

	/**
	 * Will return the next Event in line and then remove it.
	 * @author Samuel Gradén
	 * @return The next event
	 */
	public Event next() {
		
		Event output = this.EventList.get(0);
		this.EventList.remove(0);
		return output;
	}
	public Event getEvent() {
		return this.EventList.get(0);
	}

	/**
	 * Checks if the next Event is the end
	 * 
	 * @author Samuel Gradén
	 * @return True if the next event is the EventEnd
	 */
	public boolean isEnd() {
		if (this.EventList.get(0) instanceof EventEnd) {
			return true;
		} else {
			return false;
		}
	}
//	public static void main(String[] args0) {
//		EventQueue EQ = new EventQueue();
//
//		System.out.println("TestQueue");
//		for(int i = 10; i>0; i--) {
//			Event test1 = new Event();
//			test1.setTime((int)(1000*Math.random()));
//			System.out.println(test1.getName() + " 	Time: " + test1.getTime() );
//			EQ.add(test1);
//		}
//
//		for(int i = 0; i<EQ.EventList.size();i++) {
//			System.out.println(EQ.EventList.get(i) + " 	time: " + EQ.EventList.get(i).getTime() );
//
//		}
//
//
//
//
//	}

}
