package lab5.State;

public class StateStore extends State{
	
	final static int maxCustomers = 50;
	int missedCustomers = 0;

	public StateStore(double dLower, double dUpper, long lSeed, double dLambda) {
		super(dLower, dUpper,lSeed, dLambda);
	}
	
	public StateStore(double dLower, double dUpper, double dLambda) {
		super(dLower, dUpper, dLambda);
	}

	public static int getMaxCustomers(){
		
		return maxCustomers;		
	}
	
}
