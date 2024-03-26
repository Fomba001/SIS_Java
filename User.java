package sis; // Add the package declaration

import java.awt.*; // Import the necessary classes
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class User extends JFrame implements ActionListener {
	    private University university; // Create a single instance of the University class
	    private JTextField studentIdField = new JTextField();
	    private JTextField studentNameField = new JTextField();
	    private JTextField studentDobField = new JTextField();
	    private JTextField courseIdField = new JTextField();
	    private JTextField courseTitleField = new JTextField();
	    private JTextField courseInstructorField = new JTextField();
	    private JTextField gradeField = new JTextField();
	    private JTextArea outputArea;
	    
	    private JButton addButton = new JButton("Add Student");
	    private JButton removeButton = new JButton("Remove Student");
	    private JButton addCourseButton = new JButton("Add Course");
	    private JButton removeCourseButton = new JButton("Remove Course");
	    private JButton enrollButton = new JButton("Enroll Student");
        private JButton showEnrollmentsButton = new JButton("Show Enrollments");
        private JButton clearButton = new JButton("Clear");

	    // Constructor
	    public User() {
	        this.university = new University();

	        setTitle("Student Information System"); // Set up the main frame
	        setSize(400, 300);
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setLayout(new BorderLayout());

	        JPanel inputPanel = new JPanel(); // Create the input panel
	        inputPanel.setLayout(new GridLayout(8, 2)); // Change the grid layout to 8 rows and 2 columns

	         // Adding the labels and fields to the input panel
	        
	        inputPanel.add(new JLabel("Student ID:"));
	        inputPanel.add(studentIdField);
	         
	        inputPanel.add(new JLabel("Student Name:"));
	        inputPanel.add(studentNameField);
	       
	        inputPanel.add(new JLabel("Student Date of Birth:"));
	        inputPanel.add(studentDobField);
	        
	        inputPanel.add( new JLabel("Course ID:"));
	        inputPanel.add(courseIdField);
	   
	        inputPanel.add( new JLabel("Course Title:")); 
	        inputPanel.add(courseTitleField);
	       
	        inputPanel.add( new JLabel("Course Instructor:")); 
	        inputPanel.add(courseInstructorField);
	        
	        inputPanel.add(new JLabel("Grade:"));
	        inputPanel.add(gradeField);

	        // Create the button panel
	        JPanel buttonPanel = new JPanel();
	        buttonPanel.setLayout(new FlowLayout());

	     // Add a button for enrolling a student in a course
	        addButton.addActionListener(this);    
	        removeButton.addActionListener(this);
	        addCourseButton.addActionListener(this);
	        removeCourseButton.addActionListener(this);
	        enrollButton.addActionListener(this);     
	        showEnrollmentsButton.addActionListener(this);
	        clearButton.addActionListener(this);
	        	        
	        buttonPanel.add(addButton);
	        buttonPanel.add(removeButton);
	        buttonPanel.add(addCourseButton);
	        buttonPanel.add(removeCourseButton);
	        buttonPanel.add(enrollButton);
	        buttonPanel.add(showEnrollmentsButton); 
	        buttonPanel.add(clearButton);

	        outputArea = new JTextArea(); // Create the output area
	        outputArea.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(outputArea);

	        add(inputPanel, BorderLayout.NORTH); // Add the components to the main frame
	        add(buttonPanel, BorderLayout.CENTER);
	        add(scrollPane, BorderLayout.SOUTH);
	        
	       // Student student = new Student(21098, "John", "12/06/2000");
          //  university.addStudent(student);

	    }
		
	    @Override
	    public void actionPerformed(ActionEvent action) {

	        if (action.getSource() == addButton) 
	        {
	        	String studentId = studentIdField.getText();  // Get the student details from the field
	 	        String studentName = studentNameField.getText();
	 	        String studentDob = studentDobField.getText();
	 	       
	 	        if (studentId.isEmpty() || studentName.isEmpty() || studentDob.isEmpty()) { // Check if any of the fields are empty
	 	            outputArea.setText("Please enter a valid student ID, name, and date of birth.");
	 	        } 
	 	        else 
	 	        {
	 	        	try {
	 	        		 Student student = new Student(Integer.parseInt(studentId), studentName, studentDob);
	 	        		   university.addStudent(student);
	 	        		   outputArea.setText("Student added successfully:\n" +
	 	  	                    "Student ID: " + student.getStudentID() +
	 	  	                    "\nName: " + student.getName() +
	 	  	                    "\nDate of Birth: " + student.getDob()); 	            
	 	        	} 
	 	        	catch (Exception e) {
	 	        	
	 	        		JOptionPane.showMessageDialog(this, "Type your name, studentID and Date of birth correctly: ", "Error", JOptionPane.ERROR_MESSAGE);
	 	        	}     
	 	           
	 	        }
	 	    }
	        else if (action.getSource() == removeButton) {
	        
	        	    String studentId = studentIdField.getText();
	        	    if (studentId.isEmpty()) {
	        	    
	        	        outputArea.setText("Please enter a valid student ID.");
	        	    } 
	        	    else {
	        	  
	        	        try {
	        	            int studentID = Integer.parseInt(studentId);
	        	            Student studentToRemove = new Student(studentID, "", ""); // Creating a student for comparison
	        	            university.removeStudent(studentToRemove);
	        	            outputArea.setText("Student removed successfully.");
	        	        } 
	        	        catch (NumberFormatException e) {
	        	        
	        	            JOptionPane.showMessageDialog(this, "Please enter a valid student ID.", "Error", JOptionPane.ERROR_MESSAGE);
	        	        }
	        	}
	        }
	        else if(action.getSource() == addCourseButton) 
	        {
	        	String courseCode = courseIdField.getText();
	            String courseTitle = courseTitleField.getText();
	            String courseInstructor = courseInstructorField.getText();

	            if (courseCode.isEmpty() || courseTitle.isEmpty() || courseInstructor.isEmpty()) {
	                outputArea.setText("Please enter a valid course code, title, and instructor.");
	            } else {
	                try {
	                    Course course = new Course(courseCode, courseTitle, courseInstructor);
	                    university.addCourse(course);
	                    outputArea.setText("Course added successfully:\n" +
	                            "Course Code: " + course.getCourseCode() +
	                            "\nTitle: " + course.getTitle() +
	                            "\nInstructor: " + course.getInstructor());
	                } catch (Exception e) {
	                    JOptionPane.showMessageDialog(this, "Error adding course. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	        else if(action.getSource() == removeCourseButton) 
	        {
	        	String courseCode = courseIdField.getText();

	            if (courseCode.isEmpty()) {
	                outputArea.setText("Please enter a valid course code.");
	            } else {
	                try {
	                    Course courseToRemove = new Course(courseCode, "", ""); // Creating a course for comparison
	                    university.removeCourse(courseToRemove);
	                    outputArea.setText("Course removed successfully.");
	                } catch (Exception e) {
	                    JOptionPane.showMessageDialog(this, "Error removing course. Please check your input.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	        else if(action.getSource() == enrollButton) 
	        {
	        	String studentId = studentIdField.getText();
	            String courseCode = courseIdField.getText();
	            String grade = gradeField.getText();

	            if (studentId.isEmpty() || courseCode.isEmpty() || grade.isEmpty()) {
	                outputArea.setText("Please enter a valid student ID, course code, and grade.");
	            } else {
	                try {
	                    int studentID = Integer.parseInt(studentId);
	                    Student studentToEnroll = new Student(studentID, "", ""); // Creating a student for comparison

	                    int enrollmentID = generateEnrollmentID(); // You need to implement a method to generate unique enrollment IDs

	                    Course courseToEnroll = new Course(courseCode, "", ""); // Creating a course for comparison

	                    Enrollment enrollment = new Enrollment(enrollmentID, studentToEnroll, courseToEnroll, grade);
	                    university.enrollStudentInCourse(studentToEnroll, courseToEnroll);
	                    outputArea.setText("Student enrolled successfully:\n" +
	                            "Enrollment ID: " + enrollment.getEnrollmentID() +
	                            "\nStudent ID: " + studentToEnroll.getStudentID() +
	                            "\nCourse Code: " + courseToEnroll.getCourseCode() +
	                            "\nGrade: " + grade);
	                } catch (NumberFormatException e) {
	                    JOptionPane.showMessageDialog(this, "Please enter a valid student ID.", "Error", JOptionPane.ERROR_MESSAGE);
	                }
	            }
	        }
	        else if(action.getSource() == showEnrollmentsButton) 
	        {
	        	outputArea.setText("Enrollments:\n");
	            for (Enrollment enrollment : university.getEnrollments()) {
	                outputArea.append("-----------------Enrollment------------------------\n");
	                outputArea.append("Enrollment ID: " + enrollment.getEnrollmentID() + "\n");
	                outputArea.append("Student ID: " + enrollment.getStudent().getStudentID() + "\n");
	                outputArea.append("Course Code: " + enrollment.getCourse().getCourseCode() + "\n");
	                outputArea.append("Grade: " + enrollment.getGrade() + "\n");
	            }
	        }

	        else if (action.getSource() == clearButton)  // Clear all text fields
	        {
	            studentIdField.setText("");
	            studentNameField.setText("");
	            studentDobField.setText("");
	            courseIdField.setText("");
	            courseTitleField.setText("");
	            courseInstructorField.setText("");
	            gradeField.setText("");
	            outputArea.setText(""); // Clear the output area
	        }
	     }

	    private int generateEnrollmentID() {
	        return university.generateEnrollmentID();
	    }

}