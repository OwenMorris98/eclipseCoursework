/*
 * COSC 310-001   Assignment 8

 * Astro.java
 *
 * This class creates an astro class to hold a name x coordinate
 * and y coordinate, as well as the distance between other entities
 * 
 * @author  Owen Morris

 */
public class Astro implements Comparable {
	private String name;
	private int xCoord;
	private int yCoord;
	private double distance;

	public Astro(String name, int xCoord, int yCoord, double distance) {
		super();
		this.name = name;
		this.xCoord = xCoord;
		this.yCoord = yCoord;
		this.distance = distance;

	}

	public Astro() {
		super();

	}

	public String getName() {
		return name;
	}

	public int getxCoord() {
		return xCoord;
	}

	public int getyCoord() {
		return yCoord;
	}

	public double getDistance() {
		return distance;
	}

	@Override
	public String toString() {
		return String.format("%-14s %-3d %-3d %-5.2f", name, xCoord, yCoord, distance);
	}

	@Override
	public int compareTo(Object arg) {
		if (this.distance > ((Astro) arg).distance) {
			return 1;
		} else if (this.distance < ((Astro) arg).distance) {
			return -1;
		} else {
			return 0;
		}
	}

}
