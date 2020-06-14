package nico.predatorprey.simulation;

import java.awt.Color;

public class Cell {

	public static final short PREY_LIFE = 100;
	public static final short PREDATOR_LIFE = 100;
	
	private Color color;
	private short lifetime;
	
	public Cell(Color color) {
		this.color = color;
		this.lifetime = 0;
	}
	
	public Color getColor() {
		return new Color(color.getRed() * (PREDATOR_LIFE-lifetime)/PREDATOR_LIFE, color.getGreen() * lifetime/PREY_LIFE, color.getBlue());
	}
	
	public short getLifetime() {
		return lifetime;
	}
	
	public void increaseLifetime() {
		this.lifetime++;
	}
	
	public boolean isPrey() {
		return color == Color.GREEN;
	}
	
	public boolean isPredator() {
		return color == Color.RED;
	}
	
	public boolean isEmpty() {
		return color == Color.BLACK;
	}
}
