package nico.predatorprey;

import javax.swing.Timer;

public class Main {

	private static Simulation simulation;
	private static Timer timer;
	
	public static void main(String[] args) {
		simulation = new Simulation();
		
		WindowManager.createWindow(simulation);
		
		timer = new Timer(20, simulation);
		timer.start();
	}
}
