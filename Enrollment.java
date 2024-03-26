package sis;

public class Enrollment {
	
	    private int enrollmentID;
	    private Student student;
	    private Course course;
	    private String grade;
	   
	    public Enrollment(int enrollmentID, Student student, Course course, String grade) // Constructor
	    { 
	        this.enrollmentID = enrollmentID;
	        this.student = student;
	        this.course = course;
	        this.grade = grade;
	    }

		public int getEnrollmentID() // Getters and Setters
	    {  
	        return enrollmentID;
	    }

	    public void setEnrollmentID(int enrollmentID) 
	    {
	        this.enrollmentID = enrollmentID;
	    }

	    public Student getStudent() 
	    {
	        return student;
	    }

	    public void setStudent(Student student) 
	    {
	        this.student = student;
	    }

	    public Course getCourse() 
	    {
	        return course;
	    }

	    public void setCourse(Course course) 
	    {
	        this.course = course;
	    }

	    public String getGrade() 
	    {
	        return grade;
	    }

	    public void setGrade(String grade) 
	    {
	        this.grade = grade;
	    }
	 

	     public void displayEnrollmentDetails() 
	     {
	            System.out.println("Enrollment ID: " + enrollmentID);
	            System.out.println("Student ID: " + student.getStudentID());
	            System.out.println("Course Code: " + course.getCourseCode());
	            System.out.println("Grade: " + grade);
	     }  
}

