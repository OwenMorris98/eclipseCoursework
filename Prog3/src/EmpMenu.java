
/*
 * COSC 310-001   Assignment 3

 * EmpMenu.java
 *
 * This class creates a menu that can display all 
 * employees, create new employees, and search for employees
 * in a single linked list
 * 
 * @author  Owen Morris

 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class EmpMenu {
	String employeeID = null;
	String firstName = null;
	String lastName = null;
	double salary;
	int index = 0;
	
	Scanner input = new Scanner(System.in);

	private SLList<Employee> list = new SLList<Employee>();

	public EmpMenu() {
		Scanner inFile = null;

		try {
			inFile = new Scanner(new File("employee.txt"));
		} catch (FileNotFoundException e) {
			System.err.println("Error: File not found");
		}

		// Reads the employee file
		while (inFile.hasNext()) {
			String record = inFile.nextLine();
			String[] tokens = record.split(",[ ]*");
			employeeID = tokens[0];
			firstName = tokens[1];
			lastName = tokens[2];
			salary = Double.parseDouble(tokens[3]);
			Employee e = new Employee(employeeID, firstName, lastName, salary);
			list.add(new Employee(employeeID, firstName, lastName, salary));

		}

	}

	public void display() {
		int option = displayMenu();
		while (option != 0) {
			switch (option) {
			case 1:
				option1();
				break;
			case 2:
				option2();
				break;
			case 3:
				option3();
				break;
			case 4:
				option4();
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
		System.out.println("  2. Find employee");
		System.out.println("  3. Add employee");
		System.out.println("  4. Remove employee");
		System.out.println("  0. Exit");
		System.out.print("Enter number: ");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}

	/*
	 * Method that prints all the employees and their information
	 */
	private void option1() {
		System.out.printf("%-12s %-14s%-8s     %-10s\n", "Employee ID", "First Name", "Last Name", "salary");

		for (int i = 0; i < list.size(); i++) {
			System.out.printf("%-12s %-8s\t   %-12s  %1s%,-10.2f\n", list.get(i).getEmployeeID(),
					list.get(i).getFirstName(), list.get(i).getLastName(), "$", list.get(i).getSalary());
		}
	}

	/*
	 * method that searches and finds an employee the user wants
	 */
	private void option2() {
		System.out.println("Enter Employee ID: ");
		String target = input.next();

		for (int i = 0; i < list.size(); i++) {
			Employee e = list.get(i);

			if (e.getEmployeeID().equals(target)) {

				System.out.print("\nEmployee information:\n");
				System.out.printf("%-8s %-12s  %-10s\n", "First Name", "Last Name", "salary");
				System.out.printf("%-8s   %-12s  %1s%,-10.2f\n", e.getFirstName(), e.getLastName(), "$", e.getSalary());

			}
		}

	}

	/*
	 * Method that adds an employee to the linked list
	 */
	private void option3() {
		System.out.println("Enter new employee ID: ");
		employeeID = input.next();
		System.out.println("Employees First Name: ");
		firstName = input.next();
		System.out.println("Employee Last Name: ");
		lastName = input.next();
		System.out.println("Employee salary: ");
		salary = input.nextDouble();
		list.add(new Employee(employeeID, firstName, lastName, salary));
	}

	/*
	 * Method that removes an employee from the list
	 */
	private void option4() {
		System.out.println("Enter Employee ID: ");
		String delete = input.next();
		
		for(int i = 0; i <list.size(); i++) {
			Employee e = list.get(i);
			
			if (e.getEmployeeID().equals(delete)) {
				list.remove(i);
			System.out.println("Employee Information Removed");
			}
		}
			
		
	}

}
