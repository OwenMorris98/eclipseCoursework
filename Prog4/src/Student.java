
/*
 * COSC 310-001   Assignment 4

 * Student.java
 * 
 * This class creates a student object that will be used
 * with the student menu class
 *
 * @author  Owen Morris

 */
public class Student {

	private String studentID;
	private String fName;
	private String lName;
	private String major;
	
	public Student(String studentID, String fName, String lName, String major) {
		super();
		this.studentID = studentID;
		this.fName = fName;
		this.lName = lName;
		this.major = major;
	}

	public Student() {
		super();
	}

	public String getStudentID() {
		return studentID;
	}

	public String getfName() {
		return fName;
	}

	public String getlName() {
		return lName;
	}

	public String getMajor() {
		return major;
	}
	
	/*
	 *  Overrides the compareTo method 
	 */
	
	public int compareTo(Object arg0)
    {
        return studentID.compareTo(((Student)arg0).studentID );
    }
	
	
}
