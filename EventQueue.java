package lab5.Events;

import java.util.ArrayList;


/**
 * EventQueue holds every event and keeps them in chronological order.
 * 
 * @author Samuel Gradén
 *
 */
public class EventQueue {

	private ArrayList<Event> EventList = new ArrayList<Event>();
	/**
	 * When EventQueue is created the start event; EventStart is created
	 * @author Samuel Gradén
	 */
	public EventQueue() {
		EventList.add(0, new EventStart());

		// EventList.add(new EventEnd());

	}

	/**
	 * The event will be added in and sorted after its time.
	 * @author Samuel Gradén
	 * @param 
	 * @return True when is is done
	 */
	public boolean add(Event e) {
		System.out.println("EventQueue adds: " + e.getClass().toString());

		if (EventList.size() == 0) {
			EventList.add(e);
			//System.out.println(e.getClass().toString() + ": added at index: " + 0);
			System.out.println(EventList.toString() + "  Size: " + EventList.size());
			return true;
		}
		if (e.getTime() < EventList.get(0).getTime()) {
			EventList.add(0, e);
			//System.out.println(e.getClass().toString() + ": added at index: " + EventList);
			System.out.println(EventList.toString() + "  Size: " + EventList.size());
			return true;
		}

		for (int i = 1; i < this.EventList.size() - 1; i++) {
			Event event = this.EventList.get(i);
			Event before = this.EventList.get(i - 1);
			Event next = this.EventList.get(i + 1);

			double sumTime = event.getTime();
			double sumTimeBefore = before.getTime();
			double sumTimeNext = next.getTime();

			if ((sumTime >= sumTimeBefore) && (sumTime < sumTimeNext)) {
				this.EventList.add(i, e);
				//System.out.println(e.getClass().toString() + ": added at index: " + i);
				System.out.println(EventList.toString() + "  Size: " + EventList.size());
				return true;
			}
		}

		this.EventList.add(this.EventList.size(), e);

		//System.out.println(e.getClass().toString() + ": added at index: " + this.EventList.size());
		System.out.println(EventList.toString() + "  Size: " + EventList.size());
		return true;

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
}
