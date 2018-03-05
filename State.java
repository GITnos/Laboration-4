package lab5.State;

import java.util.ArrayList;

import lab5.Sim;
/**
 * Represents the base of the state of the store, this is built up upon by StateStore
 * @author samuelgraden
 *
 */
public class State {
	
	private double currentTime = 0;
	private long seed;
	private double upper;
	private double lower;
	private double lambda;
	private Time time;
	public boolean STOP = false;
	
	public State(double dLower, double dUpper, long lSeed, double dLambda) {
		seed = lSeed;
		upper = dUpper;	
		lower = dLower;
		lambda = dLambda;
		time = new Time(lower, upper, seed, lambda);
	}
	
	public State(double dLower, double dUpper, double dLambda) {
		upper = dUpper;	
		lower = dLower;
		lambda = dLambda;
		time = new Time(lower, upper, lambda);
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
	
}
