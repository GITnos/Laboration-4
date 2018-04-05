package lab5;

import lab5.State.StateStore;

import java.util.Random;

import lab5.Events.EventQueue;
import lab5.State.State;
/**
 * @author Linnea Ossiansson
 */

public class Optimize {
    /**
     * optimizeOneSim går igenom testar en simulation flera gåner med olika antar kassor och returnerar minsta antal kassor med så få missade kuner som möjligt.
     */
	private Sim sim;
		public Optimize(Sim s) {
			sim = s;
		}
		
		public StateStore metod1(StateStore s) {
			sim = new Sim(s);
			sim.runSim();
			return sim.getState();
		}
		
		public int metod2(double dLower, double dUpper, double pLower, double pUpper, double dLambda) {
			int c = 1;
			// Number of counters
			// Missed customers
			StateStore s = new StateStore(dLower, dUpper, pLower, pUpper, dLambda, c);
			while (true) {
  			s = metod1(s);
  			if (s.getMissedCustomer()>0) {
  				s.setNumOfCounter(s.getNumOfCounter()+1);
  			} else {
  				break;
  			}
			}
			return s.getNumOfCounter();
		}
		
		public metod3(double dLower, double dUpper, double pLower, double pUpper, double dLambda, long lSeed) {
			Random r;
			while (true) {
				r = Random(lSeed);
			}
			metod2(dLower, dUpper, pLower, pUpper, dLambda);
		}
		
    private int optimizeOneSim(){
        int minMissedCustomers = -1;
        int minCounters = 1;
        EventQueue eventQ = new EventQueue();
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
