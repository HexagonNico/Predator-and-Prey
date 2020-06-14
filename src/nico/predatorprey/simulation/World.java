package nico.predatorprey.simulation;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class World {

	public static final int SIZE = 250;
	
	private Cell[][] grid;
	
	public World() {
		this.grid = new Cell[SIZE][SIZE];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				this.grid[i][j] = new Cell(Color.BLACK);
			}
		}
	}
	
	public World(Random random) {
		this.grid = new Cell[SIZE][SIZE];
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(random.nextFloat() < 0.99f)
					this.grid[i][j] = new Cell(Color.BLACK);
				else
					this.grid[i][j] = random.nextBoolean() ? new Cell(Color.GREEN) : new Cell(Color.RED);
			}
		}
	}
	
	public Cell cell(int i, int j) {
		return grid[i][j];
	}
	
	public void set(int i, int j, Cell cell) {
		this.grid[i][j] = cell;
	}
	
	public void draw(Graphics graphics) {
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				graphics.setColor(grid[i][j].getColor());
				graphics.fillRect(i*2, j*2, 2, 2);
			}
		}
	}
	
	public int getPreyCount() {
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j].isPrey())
					count++;
			}
		}
		return count;
	}
	
	public int getPredatorCount() {
		int count = 0;
		for(int i=0;i<grid.length;i++) {
			for(int j=0;j<grid[i].length;j++) {
				if(grid[i][j].isPredator())
					count++;
			}
		}
		return count;
	}
}











