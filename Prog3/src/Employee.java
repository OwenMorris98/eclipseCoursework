
/*
 * COSC 310-001   Assignment 4

 * Employee.java
 * 
 * This class creates an employee that will be used
 * with the employee menu class
 *
 * @author  Owen Morris

 */
public class Employee implements Comparable{
	private String employeeID;
	private String firstName;
	private String lastName;
	private double salary;

	public Employee(String employeeID, String firstName, String lastName, double salary) {
		super();
		this.employeeID = employeeID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
	}

	public Employee() {
		super();
	}

	public String getEmployeeID() {
		return employeeID;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public double getSalary() {
		return salary;
	}
	
	/*
	 *  Overrides the compareTo method 
	 */
	@Override
	 public int compareTo(Object arg0)
    {
        return employeeID.compareTo(((Employee)arg0).employeeID );
    }
	}                 
