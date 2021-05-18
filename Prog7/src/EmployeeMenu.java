
/*
 * @author Owen Morris
 * 
 * COSC 310 - 001 Assignment 7
 * 
 * EmployeeMenu.java
 * 
 * Class to display a menu and process the selection.
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EmployeeMenu {
	private static BST<Employee> empList = new BST<Employee>();

	/*
	 * Constructor that reads employee information from a file, creates an employee
	 * object, and adds it to a binary search tree
	 */
	public EmployeeMenu() {
		// load BST here
		// while not eof
		// 1. read record
		// 2. instantiate object with data from record
		// 3. add Employee object to BST

		String empID = null;
		String fName = null;
		String lName = null;
		double salary = 0.0;
		Scanner inFile = new Scanner(System.in);

		try {
			inFile = new Scanner(new File("employee.txt")); // scans employee txt file
		}

		catch (FileNotFoundException e)

		{
			System.err.println("File not found");
			System.exit(1);
		}
			
		while (inFile.hasNext()) {

			try {
				String record = inFile.nextLine();
				String[] tokens = record.split(",[ ]*");
				empID = tokens[0];
				fName = (tokens[1]);
				lName = (tokens[2]);
				salary = Double.parseDouble(tokens[3]);
				Employee emp = new Employee(empID, fName, lName, salary);
				empList.add(emp);
			}

			catch (InputMismatchException e)

			{
				System.err.println("File format error");
				// catch if file has wrong format
				System.exit(1);
			}
		}
		
	}
		
	

	/*
	 * Display a menu with options and call the appropriate method to perform the
	 * requested action.
	 */
	public void display() {
		int option = displayMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				displayEmployee();
				break;
			case 2:
				addEmployee();
				break;
			default:
				System.out.println("Invalid selection");
			}
			option = displayMenu();
		}
		System.out.println("Done");
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("Employee Menu");
		System.out.println("-------------");
		System.out.println("  1. Display employees");
		System.out.println("  2. Add employee");
		System.out.println("  0. Exit");
		System.out.print("Enter number: ");
		Scanner in = new Scanner(System.in);
		return in.nextInt();
	}

	/*
	 * Method to display all employees in the binary search tree
	 */
	private static void displayEmployee() {
		System.out.println(empList);
	}

	// YOUR CODE GOES HERE
//		for (int i = 0; i < list.hashCode(); i++) {
//			Employee e = list.i;
//
//				System.out.print("\nEmployee information:\n");
//				System.out.printf("%-8s %-12s  %-10s\n", "First Name", "Last Name", "salary");
//				System.out.printf("%-8s   %-12s  %1s%,-10.2f\n", e.getfName(), e.getlName(), "$", e.getSalary());

//			}

//}

	/*
	 * Method to add an employee to the binary search tree
	 */
	private static void addEmployee() {
		// YOUR CODE GOES HERE
		Scanner in = new Scanner(System.in);
		 System.out.println("Please enter employee ID.");
		 
           String employeeID = in.nextLine();
           System.out.println("Please enter employee first name.");
           String fName = in.nextLine();
           System.out.println("Please enter employee last name.");
           String lName = in.nextLine();
           System.out.println("Please enter salary.");
           double salary = in.nextDouble();

           Employee emp = new Employee(employeeID, fName, lName, salary); 
           empList.add(emp);
           

        

         
	}
     
   }

	

