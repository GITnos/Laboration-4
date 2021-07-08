package lab5.State;

import java.util.ArrayList;
import java.util.Observable;

import lab5.Sim;
import lab5.Events.Event;
/**
 * Represents the base of the state of the store, this is built up upon by StateStore
 * @author Samuel Graden, Tom Brander
 *
 */
public class State extends Observable{
	
	private Event currentEvent;
	
	private double currentTime = 0;
	private long seed;
	private double upper;
	private double lower;
	private double lambda = 1.0;
	private double pLower;
	private double pUpper;
	private Time time;
	public boolean STOP = false;
	
	public State(double dLower, double dUpper,double pLower, double pUpper, long lSeed, double dLambda) {
		seed = lSeed;
		this.upper = dUpper;	
		this.lower = dLower;
		this.lambda = dLambda;
		this.pLower = pLower;
		this.pUpper = pUpper;
		time = new Time(this.lower, this.upper,this.pLower,this.pUpper, this.seed, this.lambda);
	}
	
	public State(double dLower, double dUpper,double pLower,double pUpper, double dLambda) {
		this.upper = dUpper;	
		this.lower = dLower;
		this.lambda = dLambda;
		this.pLower = pLower;
		this.pUpper = pUpper;
		
		time = new Time(this.lower, this.upper,this.pLower,this.pUpper, this.lambda);
	}
	
	public double getArrival() {
		return time.getArrival();
	}
	
	public double getCheckout(){
		return time.getCheckout();
	}
	
	public double getGather() {
		return time.getGather();
	}
	public double getCurrentTime() {
		return this.currentTime;
	}
	public void setCurrentTimte(double time) {
		this.currentTime = time;
	}
	public Event getCurrentEvent(){
		return this.currentEvent;
	}
	public void setCurrentEvent(Event e) {
		this.currentEvent = e;
	}
	public void upView() {
		setChanged();
		notifyObservers();
	}
	
}
