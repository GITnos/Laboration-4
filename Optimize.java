package lab5;

import lab5.State.StateStore;
import lab5.Events.EventQueue;

/**
 * @author Linnea Ossiansson
 */

public class Optimize {
    private int maxCustomers = 50;

    private int optimizeOneSim(){
        int minMissedCustomers = -1;
        int minCounters = 1;
        EventQueue eventQ = new EventQueue();
        StateStore state = new StateStore(dLower,dUpper,pLower,pUpper,dLambda);
        for(int i = 1; i <= maxCustomers; i++){
            state.setNumOfCounter(i);

            while(!(eventQ.isEnd())){
                eventQ.next().run(state,eventQ);
            }

            if(minMissedCustomers == -1 || state.getMissedCustomer() < minMissedCustomers){
                minCounters = i;
                minMissedCustomers = state.getMissedCustomer();
            }
        }
        return minCounters;

    }

    public int optimizeManySim(){
        int count = 0;
        int minCounters;
        int maxMinCounters = 0;
        while(count < 100){
            minCounters = optimizeOneSim();
            if(minCounters > maxMinCounters){
                maxMinCounters = minCounters;
                count = 0;
            } else {
                count += 1;
            }
        }
        return maxMinCounters;
    }

}
