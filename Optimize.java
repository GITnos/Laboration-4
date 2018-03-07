package lab5;

import lab5.State.StateStore;
import lab5.Events.EventQueue;

/**
 * @author Linnea Ossiansson
 */

public class Optimize {
    /**
     * optimizeOneSim går igenom testar en simulation flera gåner med olika antar kassor och returnerar minsta antal kassor med så få missade kuner som möjligt.
     */
    private int optimizeOneSim(){
        int minMissedCustomers = -1;
        int minCounters = 1;
        EventQueue eventQ = new EventQueue();
        StateStore state = new StateStore(dLower,dUpper,pLower,pUpper,dLambda, counters);
        int maxCustomers = state.getMaxCustomers();
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

    /**
     * optimizeManySim går igeom många olika simulationer mha optimizeOneSim och returnerar de största minsta antal kassor
     */

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
