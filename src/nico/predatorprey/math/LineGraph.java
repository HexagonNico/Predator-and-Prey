package nico.predatorprey.math;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Stack;

public class LineGraph {

	private Stack<Integer> preyCounts;
	private Stack<Integer> predatorCounts;
	
	public LineGraph() {
		this.preyCounts = new Stack<>();
		this.predatorCounts = new Stack<>();
	}
	
	public void registerData(int prey, int predator) {
		this.preyCounts.add(new Integer(prey));
		this.predatorCounts.add(new Integer(predator));
		
		if(preyCounts.size() > 200) this.preyCounts.remove(0);
		if(predatorCounts.size() > 200) this.predatorCounts.remove(0);
	}
	
	public void draw(Graphics graphics) {
		graphics.setColor(Color.BLACK);
		graphics.fillRect(500, 0, 200, 500);
		
		graphics.setColor(Color.WHITE);
		graphics.drawRect(500, 0, 200, 500);
		
		if(!preyCounts.isEmpty()) {
			graphics.drawString("Preys: "+preyCounts.peek(), 505, 15);
			graphics.drawString("Predators: "+predatorCounts.peek(), 505, 25);
		}
		
		graphics.setColor(Color.GREEN);
		for(int i=1;i<preyCounts.size();i++) {
			graphics.drawLine(500 + i-1, 400 - preyCounts.get(i-1) / 20, 500 + i, 400 - preyCounts.get(i) / 20);
		}
		
		graphics.setColor(Color.RED);
		for(int i=1;i<predatorCounts.size();i++) {
			graphics.drawLine(500 + i-1, 400 - predatorCounts.get(i-1) / 20, 500 + i, 400 - predatorCounts.get(i) / 20);
		}
	}
}
