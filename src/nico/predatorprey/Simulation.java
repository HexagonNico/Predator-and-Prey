package nico.predatorprey;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.JPanel;

import nico.predatorprey.math.LineGraph;
import nico.predatorprey.simulation.Cell;
import nico.predatorprey.simulation.World;

public class Simulation extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	
	private final Random random;

	private World world;
	private LineGraph graph;
	
	public Simulation() {
		this.setPreferredSize(new Dimension(World.SIZE*2 + 200, World.SIZE*2));
		this.random = new Random();
		this.world = new World(random);
		this.graph = new LineGraph();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		World copy = new World();
		
		for(int i=0;i<World.SIZE;i++) {
			for(int j=0;j<World.SIZE;j++) {
				if(world.cell(i, j).isPrey()) {
					this.preyMovement(copy, i, j);
				}
				else if(world.cell(i, j).isPredator()) {
					this.predatorMovement(copy, i, j);
				}
			}
		}
		
		this.world = copy;
		this.graph.registerData(world.getPreyCount(), world.getPredatorCount());
	}
	
	private void preyMovement(World copy, int i, int j) {
		int ir = random.nextInt(3) - 1;
		int jr = random.nextInt(3) - 1;
		
		try {
			if(world.cell(i+ir, j+jr).isEmpty() && copy.cell(i+ir, j+jr).isEmpty()) {
				copy.set(i+ir, j+jr, world.cell(i, j));
				copy.cell(i+ir, j+jr).increaseLifetime();
				
				if(copy.cell(i+ir, j+jr).getLifetime() == Cell.PREY_LIFE) {
					copy.set(i+ir, j+jr, new Cell(Color.GREEN));
					copy.set(i, j, new Cell(Color.GREEN));
				}
			}
			else {
				copy.set(i, j, world.cell(i, j));
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			copy.set(i, j, world.cell(i, j));
		}
	}
	
	private void predatorMovement(World copy, int i, int j) {
		int ir = random.nextInt(3) - 1;
		int jr = random.nextInt(3) - 1;
		
		try {
			if(world.cell(i+ir, j+jr).isEmpty() && copy.cell(i+ir, j+jr).isEmpty()) {
				copy.set(i+ir, j+jr, world.cell(i, j));
				copy.cell(i+ir, j+jr).increaseLifetime();
				
				if(copy.cell(i+ir, j+jr).getLifetime() == Cell.PREDATOR_LIFE) {
					copy.set(i+ir, j+jr, new Cell(Color.BLACK));
				}
			}
			else if(world.cell(i+ir, j+jr).isPrey()) {
				copy.set(i+ir, j+jr, new Cell(Color.RED));
				copy.set(i, j, new Cell(Color.RED));
			}
			else {
				copy.set(i, j, world.cell(i, j));
			}
		} catch(ArrayIndexOutOfBoundsException e) {
			copy.set(i, j, world.cell(i, j));
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.world.draw(g);
		this.graph.draw(g);
		super.repaint();
	}

	
	
	
	
	
	
	
	
	
	
}