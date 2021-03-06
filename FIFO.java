package lab5.state;

import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.lang.ClassCastException;


public class FIFO {

	private ArrayList<Object> fifoArray = new ArrayList<Object>();
	private static int ms = 0;

	public int size() {
		return fifoArray.size();
	}
	public void add(Object item) {
		fifoArray.add(item);
		if (ms < fifoArray.size()) {
			ms += 1;
		}
	}
	public void removeFirst() throws NoSuchElementException {
		if (fifoArray.size() > 0) {
			fifoArray.remove(0);
		}else {
			throw new NoSuchElementException();
		}
	}
	public Object first() throws NoSuchElementException {
		if (fifoArray.size() > 0) {
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
		String s = "Queue: ";
		for(int i = 0; i < fifoArray.size(); i++) {
			s = s + "(" + String.valueOf(fifoArray.get(i)) + ") ";
		}
		return s;
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
