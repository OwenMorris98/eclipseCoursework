/* 
* @author Owen Morris
 * 
 * COSC 310 - 001 Assignment 7
 * 
 * Employee.java
 * 
 * Class to create an employee
 */
public class Employee implements Comparable<Employee>
{
    private String empID;
    private String fName;
    private String lName;
    private double salary;

   
    public Employee(String empID)
    {
        super();
        this.empID = empID;
    }

  
    public Employee(String empID, String fName, String lName, double salary)
    {
        super();
        this.empID = empID;
        this.fName = fName;
        this.lName = lName;
        this.salary = salary;
    }
    

    public String getempID() {
		return empID;
	}


	public String getfName() {
		return fName;
	}


	public String getlName() {
		return lName;
	}


	public double getSalary() {
		return salary;
	}


	@Override 
    public String toString() 
    {
        return empID + "  " + fName + ", " + lName + " " + salary;
    }


    @Override
    public int compareTo(Employee o) {
        return 0;
    }
}