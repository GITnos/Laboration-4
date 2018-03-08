package lab5;

import java.util.Observable;

import lab5.GUI.View;

public class Main extends Observable{

	public static void main(String[] args) {
		
		Sim testSim = new Sim(2,1234);
		View view = new View(testSim);
		testSim.runSim();
		
	}

}
