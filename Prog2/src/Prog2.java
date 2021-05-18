/*
 * @author Owen Morris
 * 
 * Class that creates a list of parts from parts.txt, then is able
 * to search a part number, and can also remove a part from the list
 */
import java.util.*;
import java.io.*;
public class Prog2 {

	public static void main(String[] args) {
		
		ListArray<Part> list = new ListArray<Part>();
		Part p;
		
		String partNum;
		String description;
		double price;
		String warehouseID;
		int quantity;
		int index = 0;
	
		Scanner inFile = null;
		Scanner in = new Scanner(System.in);
		// open file
		try {
			inFile = new Scanner(new File("parts.txt"));
		} catch (FileNotFoundException e) {
			System.out.println("Error: File not found");
		}
		System.out.printf("%-11s %-32s %-10s %-12s %-3s\n\n","Part Number","Description", 
				"Price","Warehouse ID","Quantity" );
		

		
		while (inFile.hasNext()) {
			String record = inFile.nextLine();
			String[] tokens = record.split(",[ ]*");

			partNum = tokens[0];
			description = tokens[1];
			price = Double.parseDouble(tokens[2]);
			warehouseID = tokens[3];
			quantity = Integer.parseInt(tokens[4]);

			p = new Part(partNum, description, price, warehouseID, quantity);
			list.add(p);
		}
			
			for (int i = 0; i < list.size(); i++) {
				p = list.get(i);
				System.out.printf("%-11s %-32s %-,10.2f %-12s %-3d\n", p.getPartNum(), p.getDescirption(), 
						p.getPrice(), p.getWarehouseID(), p.getQuantity());
			}
			System.out.println("\n\nEnter a Part Number: ");
			partNum = in.next();
			
			for (int i = 0; i < list.size(); i++) 
	        {
	             p =  list.get(i); 
	            
	            if (p.getPartNum().equals(partNum))
	            {

				System.out.printf("%-11s %-32s %-,10.2f %-12s %-3d\n",partNum, p.getDescirption(),p.getPrice(),
					p.getWarehouseID(),p.getQuantity());
		}
			}
			if (partNum.contains("98765")) {
				list.remove(index);
			}
			
			System.out.println("\nNew List:");
			for (int i = 0; i < list.size(); i++) {
				p = list.get(i);
			if (partNum.contains("98765")) {
				list.remove(index);
			
				
				System.out.printf("%-11s %-32s %-,10.2f %-12s %-3d\n", p.getPartNum(), p.getDescirption(), 
						p.getPrice(), p.getWarehouseID(), p.getQuantity());
			}		
			
			}	
			
			
			
			}
	}



	
	

