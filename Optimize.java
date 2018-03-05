package lab5;

        import lab5.State.StateStore;

/**
 * @author Linnea Ossiansson
 */

public class Optimize {
    public static int optimize(){
        for(int i = 1; i <= StateStore.maxCustomers; i++){
            Sim sim = new Sim(i);
            sim.runSim();
            if(sim.getState().getMissedCustomers() == 0){
                return i;
            }
        }
    }

}