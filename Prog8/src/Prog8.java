
/*
 * COSC 310-001   Assignment 8

 * Prog8.java
 *
 * This class uses a heap to take a users coordinates, and display
 * the closest entity to those coordinates
 * 
 * @author  Owen Morris

 */
import java.io.*;
import java.util.*;

public class Prog8 {
	public static void main(String[] args) throws FileNotFoundException {
		Heap<Astro> heap = new Heap<Astro>(50);
		int x; // x coordinate of point in space
		int y; // y coordinate of point in space
		int k; // number of objects desired
		String name = null;
		int xCoord = 0;
		int yCoord = 0;
		double distance = 0;
		double b = 2;
		Scanner inFile = null;
		// -----------------------------------------------------------
		// get x and y coordinates of a point in space from user
		// get number of entities k to find from user
		// -----------------------------------------------------------

		Scanner in = new Scanner(System.in);
		System.out.print("Give and x coordinate:");
		x = in.nextInt();
		System.out.println("Give a y coordinate:");
		y = in.nextInt();
		System.out.println("How many entities are near those coordinates: ");
		k = in.nextInt();

		// -----------------------------------------------------------
		// read astro.txt file, instantiate Astro objects,
		// and enqueue each one in the heap
		// -----------------------------------------------------------
		try {
			inFile = new Scanner(new File("astro.txt")); // scans astro.txt file
		}

		catch (FileNotFoundException e)

		{
			System.err.println("File not found");
			System.exit(1);
		}

		while (inFile.hasNext()) {

			try {
				String record = inFile.nextLine();
				String[] tokens = record.split("\\s+");
				name = tokens[0];
				xCoord = Integer.parseInt(tokens[1]);
				yCoord = Integer.parseInt(tokens[2]);
				distance = Math.sqrt(Math.pow(xCoord - x, b) + (Math.pow(yCoord - y, b)));
				Astro a = new Astro(name, xCoord, yCoord, distance);
				heap.enqueue(a);

			}

			catch (InputMismatchException e)

			{
				System.err.println("File format error");
				// catch if file has wrong format
				System.exit(1);
			}
		}

		// -----------------------------------------------------------
		// print k nearest objects to (x, y)
		// -----------------------------------------------------------
		System.out.println(k + " closests objects to (" + x + ", " + y + ")");
		System.out.printf("%-14s %-3s %-3s %-7s", "Name", "X", "Y", "Distance");
		System.out.println("\n-------------------------------");

		for (int i = 0; i < k; i++) {
			System.out.println(heap.dequeue());
		}

	}

}
