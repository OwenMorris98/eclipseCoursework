
/*
 * COSC 310-001   Assignment 3

 * StudentMenu.java
 *
 * This class creates a menu that can display all 
 * Students, create new Students
 * 
 * @author  Owen Morris

 */
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StudentMenu {
	String StudentID = null;
	String firstName = null;
	String lastName = null;
	String major = null;
	int index = 0;

	Scanner input = new Scanner(System.in);

	private DLList<Student> list = new DLList<Student>();

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
			default:
				System.out.println("Invalid selection");
			}
			option = displayMenu();
		}
		System.out.println("Done");
	}

	private int displayMenu() {
		System.out.println();
		System.out.println("Student Menu");
		System.out.println("-------------");
		System.out.println("  1. Add Students");
		System.out.println("  2. Display Students in Order");
		System.out.println("  3. Display Students in Reverse Order");
		System.out.println("  0. Exit");
		System.out.print("Enter number: ");
		Scanner input = new Scanner(System.in);
		return input.nextInt();
	}
	/*
	 * Method that adds an Student to the linked list
	 */

	private void option1() {
		System.out.println("Enter new Student ID: ");
		StudentID = input.next();
		System.out.println("Students First Name: ");
		firstName = input.next();
		System.out.println("Student Last Name: ");
		lastName = input.next();
		System.out.println("Student Major: ");
		major = input.next();
		list.add(new Student(StudentID, firstName, lastName, major));
	}

	/*
	 * Method that prints all the Students and their information
	 */
	private void option2() {
		System.out.printf("%-12s %-14s%-8s    %-10s\n", "Student ID", "First Name", "Last Name", "Major");

		Iterator iter = list.iterator();
		while (iter.hasNext()) {
			Student s = (Student) iter.next();
			System.out.printf("%-12s %-14s%-8s     %-10s\n", s.getStudentID(), s.getfName(), s.getlName(),
					s.getMajor());
		}

	}

	private void option3() {
		System.out.printf("%-12s %-14s%-8s    %-10s\n", "Student ID", "First Name", "Last Name", "Major");

		Iterator iter = list.revIterator();
		while (iter.hasNext()) {
			Student s = (Student) iter.next();
			System.out.printf("%-12s %-14s%-8s     %-10s\n", s.getStudentID(), s.getfName(), s.getlName(),
					s.getMajor());
		}

	}
}
