
/*  COSC 310 -001 
 *  Prog1.java
 *
 *  @author Owen Morris
 *  
 *  Reads a CSV file of states and organizes it into a table, then
 *  takes user input to search array for the correct abbreviation
 *  then prints the name and population of the state
 */
import java.util.*;
import java.io.*;
import java.util.ArrayList;

public class Prog1 {
	public static void main(String[] args) {
		String abbr;
		String name;
		int population;

		ArrayList<State> list = new ArrayList<State>();
		State s;

		Scanner inFile = null;
		// open file
		try {
			inFile = new Scanner(new File("states.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}

		// read file
		System.out.printf("%-12s %-9s %18s\n", "Abbreviation", "Name", "Population");
		System.out.printf("%-12s %-9s %18s\n", "------------", "----", "----------");

		while (inFile.hasNext()) {
			String record = inFile.nextLine();
			String[] tokens = record.split(",[ ]*");

			abbr = tokens[0];
			name = tokens[1];
			population = Integer.parseInt(tokens[2]);

			s = new State(abbr, name, population);
			list.add(s);
		}

		// loop that creates organized table of CSV file

		for (int i = 0; i < list.size(); i++) {
			s = list.get(i);
			System.out.printf("%-12s %-15s %,12d\n", s.getAbbr(), s.getName(), s.getPopulation());
		}

		// Searches array for correct abbreviation

		Scanner in = new Scanner(System.in);

		System.out.println();
		System.out.print("Enter the abbrevation for a state:");
		abbr = in.next();
		State search = new State(abbr);
		int index = list.indexOf(search);

		if (index >= 0) {
			State found = list.get(index);
			System.out.printf("%s is the abbreviation for" + " %s and has a population of %,d", abbr, found.getName(),
					found.getPopulation());

		} else {
			System.out.println(abbr + " not found");
		}
	}
}


     
