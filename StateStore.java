package lab5.State;

import java.util.ArrayList;

/**
 * 
 * @author samuelgraden
 *Represent the Store
 */
public class StateStore extends State{
	

	private FIFO fifo = new FIFO();

	private double closeTime =  10.00;
		
	private int numOfCounter = 4;
	private int numOfFreeCounter;
	private double lastCheckedTime = 0;

	private double freeCounterTime = 0;

	public final static int maxCustomers = 50;
	private int currentCustomers = 0;

	private int missedCustomers = 0;

	private ArrayList<ArrayList<Customer>> checkoutQueue = new ArrayList<ArrayList<Customer>>();

	private ArrayList<Customer> customerList = new ArrayList();
	private CreateCustomer customerCreator = new CreateCustomer();

	public StateStore(double dLower, double dUpper, double dLambda, int numOfCounter) {
		super(dLower, dUpper, dLambda);
		this.numOfCounter = numOfCounter;
		this.numOfFreeCounter = this.numOfCounter;
	}

	public StateStore(double dLower, double dUpper, long lSeed, double dLambda) {
		super(dLower, dUpper,lSeed, dLambda);
		this.numOfFreeCounter = this.numOfCounter;
	}

	public StateStore(double dLower, double dUpper, double dLambda) {
		super(dLower, dUpper, dLambda);
		this.numOfFreeCounter = this.numOfCounter;
	}
	/**
	 * createCustomer creates a customer with the CreateCustomer object,
	 * @return Customer
	 */
	public Customer createCustomer() {
		Customer customer = customerCreator.newCustomer(getArrival(), getCheckout(), getGather());
		this.customerList.add(customer);
		return customer;
	}
	public int getMaxCustomers(){	
		return this.maxCustomers;		
	}
	public int getCurrentCustomers() {
		return this.currentCustomers;
	}
	/**
	 * adds one the the customer count
	 */
	public void addCustomer() {
		this.currentCustomers++;
	}
	/**
	 * removes one from the customer count
	 */
	public void removeCustomer() {
		this.currentCustomers--;
	}
	/**
	 * adds one to the missed customer counter
	 */
	public void addMissedCustomer() {
		this.missedCustomers++;
	}

	public Customer getCustomer(int id) {
		return customerList.get(id);
	}

	public int getMissedCustomers() { return missedCustomers; }

	public int getNumOfFreeCounter() {
		return this.numOfFreeCounter;
	}
	public void decreseNumOfFreeCounter() {
		this.numOfFreeCounter--;
	}
	public void increseNumOfFreeCounter() {
		this.numOfFreeCounter++;
	}

	public Customer first() {
		return this.fifo.first();
	}
	public void removeFirst() {
		this.fifo.removeFirst();
	}
	public void add(Customer c) {
		this.fifo.add(c);
	}
	
	public double getLastCheckedTime() {
		return lastCheckedTime;
	}

	public void setLastCheckedTime(double lastCheckedTime) {
		this.lastCheckedTime = lastCheckedTime;
	}

	public double getFreeCounterTime() {
		return freeCounterTime;
	}

	public void setFreeCounterTime(double freeCounterTime) {
		this.freeCounterTime += freeCounterTime;
	}
	public double getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(double closeTime) {
		this.closeTime = closeTime;
	}


}
