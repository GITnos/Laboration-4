package lab5.State;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Observable;
import java.lang.ClassCastException;

/**
 * Represents the queue for the counters
 * @author Tom Brander
 *
 */
public class FIFO {

	private ArrayList<Customer> fifoArray = new ArrayList<Customer>();
	private static int ms = 0;

	public int size() {
		return fifoArray.size();
	}
	public void add(Customer item) {
		fifoArray.add(item);
		if (ms < fifoArray.size()) {
			ms += 1;
		}
	}
	public void removeFirst() throws NoSuchElementException {
		if (fifoArray.size() > 0) {
			fifoArray.remove(0);
		}else {
			System.out.println("SpecialFall");
			throw new NoSuchElementException();
		}
	}
	public Customer first() throws NoSuchElementException {
		if (fifoArray.size() >0) {
			//System.out.println("First in FIFO is:" + fifoArray.get(0));
			return fifoArray.get(0);
		}else {
			throw new NoSuchElementException();
		}
	}
	public int maxSize() {
		return ms;
	}
	public boolean isEmpty() {
		if (size() > 0) {
			return false;
		} else {
			return true;
		}
	}

	public String toString() {
		if(fifoArray.size()== 0){
			return "[]";
		}
		String s = "[";
		if(fifoArray.size() == 1){
			return s + fifoArray.get(0).getId() + "]";
		}
		s = s + fifoArray.get(0).getId();
		for(int i = 1; i < fifoArray.size(); i++) {
			s = s + "," + fifoArray.get(i).getId();
		}
		return s + "]";
	}
	public boolean equals(Object f) throws ClassCastException {
		if (f instanceof FIFO) {
			if ( this.fifoArray.size() == ((FIFO) f).fifoArray.size()) {
				for (int i = 0; i < this.fifoArray.size(); i++) {
					if ( this.fifoArray.get(i) == null) {
						if (((FIFO)f).fifoArray.get(i) == null) {
							continue;
						}else {
							return false;
						}
					}
					if ( this.fifoArray.get(i).equals(((FIFO) f).fifoArray.get(i))) {
						continue;
					} else {
						return false;
					}
				} return true;
			}else {
				return false;
			}
		} 
		else {
			throw new ClassCastException();
		}
	}

}
