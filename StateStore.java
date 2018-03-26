package lab5.State;

import java.util.ArrayList;

/**
 * Represent the Store
 * @author Samuel GradÃ©n
 */
public class StateStore extends State{
	
	private FIFO fifo = new FIFO();
	private double closeTime =  10.00;
	private int numOfCounter = 4;
	private Boolean isOpen = true;
	private int qdCustomers = 0;
	
	private int numOfFreeCounter;
	private double lastCheckedTime = 0.0;
	private double queueTime = 0.0;

//	private ArrayList<Integer> queue = new ArrayList<Integer>();
	
	private double freeCounterTime = 0;

	private int maxCustomers = 50;
	private int currentCustomers = 0;
	private int missedCustomers = 0;

	//private ArrayList<ArrayList<Customer>> checkoutQueue = new ArrayList<ArrayList<Customer>>();

	private ArrayList<Customer> customerList;
	private CreateCustomer customerCreator = new CreateCustomer();

	
	
	public StateStore(double dLower, double dUpper,double pLower, double pUpper, long seed, double dLambda,int counters) {
		super(dLower, dUpper,pLower,pUpper,seed, dLambda);
		this.customerList = new ArrayList<Customer>();
		this.numOfCounter = counters;
		this.numOfFreeCounter = this.numOfCounter;
	}

	public StateStore(double dLower, double dUpper,double pLower, double pUpper,  double dLambda,int counters) {
		super(dLower, dUpper,pLower,pUpper, dLambda);
		this.customerList = new ArrayList<Customer>();
		this.numOfCounter = counters;
		this.numOfFreeCounter = this.numOfCounter;
	}
	
	
	/**
	 * createCustomer creates a customer with the CreateCustomer object,
	 * @return Customer
	 * @author Samuel GradÃ©n
	 */
	public Customer createCustomer() {
		Customer customer = customerCreator.newCustomer(getArrival(), getCheckout(), getGather());
		this.customerList.add(customer);
		return customer;
	}
	/**
	 * 
	 * @return the maximum amount of customers allowed in the store
	 */
	public int getMaxCustomers(){	
		return this.maxCustomers;		
	}
	/**
	 * Sets the number of customers allowed in the store
	 * @param n
	 */
	public void setMaxCustomers(int n) {
		this.maxCustomers = n;
	}
	/**
	 * 
	 * @return the number of customers in the store
	 */
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
	 * Removes one from the customer count
	 */
	public void removeCustomer() {
		this.currentCustomers--;
	}
	/**
	 * Adds one to the missed customer counter
	 */
	public void addMissedCustomer() {
		this.missedCustomers++;
	}
	/**
	 * 
	 * @return the number of missed customers
	 */
	public int getMissedCustomer() {
		return this.missedCustomers;
	}
	/**
	 * 
	 * @param id of the customer
	 * @return the customer with the id
	 */
	public Customer getCustomer(int id) {
		//System.out.println("StateStore id:" + id);
		return customerList.get(id);
	}
	/**
	 * 
	 * @return sum of queue times for all customers
	 */
	public double getqTime() {
		return this.queueTime;
	}
	
	/**
	 * 
	 * @return the number of free counters
	 */
	public int getNumOfFreeCounter() {
		return this.numOfFreeCounter;
	}
	/**
	 * Decreases the number of free counters
	 */
	public void decreseNumOfFreeCounter() {
		this.numOfFreeCounter--;
	}
	/**
	 * Increases the number of free counters
	 */
	public void increseNumOfFreeCounter() {
		this.numOfFreeCounter++;
	}

	/**
	 * 
	 * @return the first in line in the queue
	 */
	public Customer first() {
		return this.fifo.first();
	}
	/**
	 * removes the first customer in the queue
	 */
	public void removeFirst() {
		this.fifo.removeFirst();
	}
	/**
	 * Adds a customer to the queue
	 * @param c
	 */
	public void add(Customer c) {
		this.fifo.add(c);
		qdCustomers++;
	}
	/**
	 * 
	 * @return the size of the queue
	 */
	public int size() {
		return this.fifo.size();
	}
	
	public String getQueue(){
		return fifo.toString();
		
	}
	/**
	 * help method for keeping track the freeCounterTime
	 * @return time
	 */
	public double getLastCheckedTime() {
		return lastCheckedTime;
	}
	
	public void setLastCheckedTime(double lastCheckedTime) {
		this.lastCheckedTime = lastCheckedTime;
	}
	
	public double getQueueTime() {
		return queueTime;
	}

	public void addQueueTime(double queueTime) {
		this.queueTime = this.queueTime + queueTime;
	}
	
	/**
	 * 
	 * @return the amount of time the counters have been empty
	 */
	public double getFreeCounterTime() {
		return freeCounterTime;
	}
	/**
	 * @param freeCounterTime
	 */
	public void setFreeCounterTime(double freeCounterTime) {
		this.freeCounterTime += freeCounterTime;
	}
	/**
	 * @return the time when the store shall close
	 */
	public double getCloseTime() {
		return closeTime;
	}
	/**
	 * 
	 * @param closeTime
	 */
	public void setCloseTime(double closeTime) {
		this.closeTime = closeTime;
	}
	/**
	 * 
	 * @return number of counters
	 */
	public int getNumOfCounter() {
		return numOfCounter;
	}
	/**
	 * Sets the NumberOfCounter
	 * @param numOfCounter
	 */
	public void setNumOfCounter(int numOfCounter) {
		this.numOfCounter = numOfCounter;
	}
	/**
	 * 
	 * @return the size of the queue
	 */
	public int listSize() {
		return this.customerList.size();
	}
	
	/**
	 * 
	 * @return amount of checked out customers
	 */
	public int getCheckedOutCustomers() {
		return listSize()-1 - getCurrentCustomers() - getMissedCustomer();
	}
	/**
	 * 
	 * @return the name of latest run event
	 */
	public String getEventName() {
		String s = "";
		
	// Skriv in dina grejjer hÃ¤r, Samuel of house Tarly
		
		return s;
	}
	/**
	 * 
	 * @return the id of the latest run event
	 */
	public int getEventid() {
		int n = 0;
		

		
		return n;
	}
	
	public Boolean isOpen() {
		return isOpen;
	}
	
	public void flipIsOpen(){
		isOpen=!isOpen;
	}
	
	public int getQdCustomers() {
		return qdCustomers;
	}
	
}
