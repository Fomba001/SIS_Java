package sis;
	
public class Course {
	
	    private String courseCode;
	    private String title;
	    private String instructor;

	   
	    public Course(String courseCode, String title, String instructor) // Constructor
        { 
	        this.courseCode = courseCode;
	        this.title = title;
	        this.instructor = instructor;
	    }

	   
	    public String getCourseCode() 
	    { 
	        return courseCode;
	    }

	    public void setCourseCode(String courseCode) // Getters and Setters
	    {
	        this.courseCode = courseCode;
	    }

	    public String getTitle() 
	    {
	        return title;
	    }

	    public void setTitle(String title) 
	    {
	        this.title = title;
	    }

	    public String getInstructor() 
	    {
	        return instructor;
	    }

	    public void setInstructor(String instructor) 
	    {
	        this.instructor = instructor;
	    }

	    public void displayCourseDetails()  // Method to display course details
	    { 
	        System.out.println("Course Code: " + courseCode);
	        System.out.println("Title: " + title);
	        System.out.println("Instructor: " + instructor);
	    }
}


