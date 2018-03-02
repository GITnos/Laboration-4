package lab5.State;

import java.util.ArrayList;

import lab5.Sim;

public class StateStore extends State{
	
	final int maxCustomers = 50;
	private int currentCustomers = 0;
	private int missedCustomers = 0;
	private ArrayList<Customer> customerList = new ArrayList();

	public StateStore(double dLower, double dUpper, long lSeed, double dLambda) {
		super(dLower, dUpper,lSeed, dLambda);
	}
	
	public StateStore(double dLower, double dUpper, double dLambda) {
		super(dLower, dUpper, dLambda);
	}
	public Customer createCustomer() {
		Customer customer = new Customer(this.getArrival(),this.getGather(),this.getGather());
		this.customerList.add(customer);
		return customer;
	}
	public int getMaxCustomers(){	
		return this.maxCustomers;		
	}
	public int getCurrentCustomers() {
		return this.currentCustomers;
	}
	public void addCustomer() {
		this.currentCustomers++;
	}
	public void removeCustomer() {
		this.currentCustomers--;
	}
	public void addMissedCustomer() {
		this.missedCustomers++;
	}
	public Customer getCustomer(int id) {
		return customerList.get(id);
	}
	
}
