package lab5.State;
import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;

public class Time {


	ExponentialRandomStream randExp;
	UniformRandomStream randUni;
	UniformRandomStream plockRandUni;
	private double currentTime = 0.0d;

	public Time(double lower, double upper, double pLower, double pUpper, long seed, double lambda){
		randExp = new ExponentialRandomStream(lambda, seed);
		randUni = new UniformRandomStream(lower, upper, seed);
		plockRandUni = new UniformRandomStream(pLower,pUpper,seed);
	}

	public UniformRandomStream getPlockRandUni() {
		return plockRandUni;
	}

	public void setPlockRandUni(UniformRandomStream plockRandUni) {
		this.plockRandUni = plockRandUni;
	}

	public Time(double lower, double upper, double pLower, double pUpper, double lambda){
		randExp = new ExponentialRandomStream(lambda);
		randUni = new UniformRandomStream(lower, upper);
		plockRandUni = new UniformRandomStream(pLower,pUpper);
	}

	public double getArrival(){
		return randExp.next();
	}

	public double getGather(){
		return plockRandUni.next();
	}

	public double getCheckout(){
		return randUni.next();
	}

	public double getTime(){
		return currentTime;
	}

}
