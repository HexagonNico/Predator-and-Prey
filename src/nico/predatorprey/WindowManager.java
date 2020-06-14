package nico.predatorprey;

import javax.swing.JFrame;

public class WindowManager {

	private static JFrame frame;
	
	public static void createWindow(Simulation simulation) {
		frame = new JFrame("Predator and Prey");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.add(simulation);
		frame.pack();
		frame.setVisible(true);
	}
}
