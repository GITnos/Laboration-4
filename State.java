package lab5.State;

public class State {
	
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
	
	public Customer createCustomer() {
		Customer customer = new Customer(this.getArrival(),this.getGather(),this.getGather());
		customerList.add(customer);
		return customer;
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
	
}
