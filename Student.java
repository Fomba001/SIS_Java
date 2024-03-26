package sis;

public class Student {
	
	    private int studentID;
	    private String name;
	    private String dob;

	    public Student(int studentID, String name, String dob) // Constructor
	    { 
	        this.studentID = studentID;
	        this.name = name;
	        this.dob = dob;
	    }

	   
	    public int getStudentID() // Getters and Setters
	    { 
	        return studentID;
	    }

	    public void setStudentID(int studentID) 
	    {
	        this.studentID = studentID;
	    }

	    public String getName() 
	    {
	        return name;
	    }

	    public void setName(String name) 
	    {
	        this.name = name;
	    }

	    public String getDob() 
	    {
	        return dob;
	    }

	    public void setDob(String dob) 
	    {
	        this.dob = dob;
	    }

	    public void displayStudentDetails()  // Method to display student details
	    { 
	        System.out.println("Student ID: " + studentID);
	        System.out.println("Name: " + name);
	        System.out.println("Date of Birth: " + dob);
	    }
}
