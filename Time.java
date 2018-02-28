package lab5.State;
import lab5.random.ExponentialRandomStream;
import lab5.random.UniformRandomStream;

public class Time {
  
  ExponentialRandomStream randExp;
  UniformRandomStream randUni;
  private double currentTime = 0.0d;
  
  public Time(double lower, double upper, long seed, double lambda){
    randExp = new ExponentialRandomStream(lambda, seed);
    randUni = new UniformRandomStream(lower, upper, seed);
  }
  
  public Time(double lower, double upper, double lambda){
	randExp = new ExponentialRandomStream(lambda);
	randUni = new UniformRandomStream(lower, upper);
  }
 
  public double getArrival(){
    return randExp.next();
  }
  
  public double getGather(){
    return randUni.next();
  }
  
  public double getCheckout(){
    return randUni.next();
  }
  
  public double getTime(){
    return currentTime;
  }
    
}
