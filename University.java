package sis;
	
import java.util.*;

public class University {
	
	    private ArrayList<Student> students;
	    private ArrayList<Course> courses;
	    private ArrayList<Enrollment> enrollments;
	    private int nextEnrollmentID = 1;
	   

		public University()  // Constructor
	    {
	        students = new ArrayList<>();
	        courses = new ArrayList<>();
	        enrollments = new ArrayList<>();
	    }
	   
	    public void addStudent(Student student) {
	        students.add(student);
	    }

	    public void removeStudent(Student student) {
	        students.remove(student);
	    }

	    public void addCourse(Course course) {
	        courses.add(course);
	    }

	    public void removeCourse(Course course) {
	        courses.remove(course);
	    }
	    
	    public void enrollStudentInCourse(Student student, Course course) {
	        // Create an enrollment with the generated ID
	        Enrollment enrollment = new Enrollment(generateEnrollmentID(), student, course,null);
	        enrollments.add(enrollment);
	    }

	    int generateEnrollmentID() {
	    	
	    	 return nextEnrollmentID++;
	 
	    }

	    public void viewStudentDetails(Student student) {
	    	System.out.println("-----------------Student Details------------------------");
	        for (Student s : students) {
	            if (s.equals(student)) {
	                s.displayStudentDetails();
	                return;
	            }
	        }
	        System.out.println("Student not found in the university.");
	    }

		public Enrollment[] getEnrollments() {
			
			return enrollments.toArray(new Enrollment[0]);
		}

		

		
}

