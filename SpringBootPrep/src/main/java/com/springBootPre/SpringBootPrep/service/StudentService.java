package com.springBootPre.SpringBootPrep.service;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Component;

import com.springBootPre.SpringBootPrep.model.Course;
import com.springBootPre.SpringBootPrep.model.Student;

@Component
public class StudentService {

	private static List<Student> students = new ArrayList<Student>();

	static {
				
		Course course1=new Course("C1","Mathmatics","OnlyMaths",new ArrayList<>(
				Arrays.asList("Introduction","Basic Arthmatics function","Calculus","Inegration")));
		
		Course course2=new Course("C2","Science","onlyScience",new ArrayList<>(
				Arrays.asList("Introduction","Basic Science","A","C")));
		Course course3=new Course("C3","C","D",new ArrayList<>(
				Arrays.asList("Introduction","A","B","Inegration")));
		Course course4=new Course("C4","E","OnlyMaths",new ArrayList<>(
				Arrays.asList("Introduction","Basic Arthmatics function","Calculus","Inegration")));
		
		Student s1=new Student("s1", "S1_A", "S1_A_D", new ArrayList<>(Arrays.asList(course1,course2,course3)));
		Student s2=new Student("s2", "s2_A", "S2_A_D", new ArrayList<>(Arrays.asList(course1,course2,course4)));
		Student s3=new Student("s3", "s3_A", "S3_A_D", new ArrayList<>(Arrays.asList(course1,course2,course4)));
		Student s4=new Student("s4", "s4_A", "S4_A_D", new ArrayList<>(Arrays.asList(course1,course2)));
		
		students.add(s1);
		students.add(s2);
		students.add(s3);
		students.add(s4);
	}
		public List<Student> retrieveAllStudent()
		{
			return students;
		}
		
	   public Student retrieveStudent(String id) 
	   {
		   for(Student st:students) 
		   {
			   if(st.getId().equals(id)) {
				   return st;
			   }
		   }
		   
		   return null;
	   }

	   public List<Course> retrieveCourses(String id)
	   {
		   Student st=retrieveStudent(id);
		   
		   return st.getCourses();
	   }
	   
	   public Course retrieveCourse(String studentId,String courseId)
	   {
		   Student st=retrieveStudent(studentId);
		   
		   if(st==null) {return null;}
		   
		   for(Course cou:st.getCourses()) {
			   if(cou.getId().equals(courseId)) {
				   return cou;
			   }
		   }
		   
		   return null;
	   }
	   
	   private SecureRandom sr=new SecureRandom();
	   
	   public Course addCourse(String studentId,Course course) 
	   {
		   Student stu=retrieveStudent(studentId);
		   
		   String randomId=new BigInteger(130, sr).toString();
		   course.setId(randomId);
		   
		   stu.getCourses().add(course);
		   
		   return course;
	   }
	   
	   
}
