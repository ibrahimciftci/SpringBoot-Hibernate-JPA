package com.springboot.hibernatejpa;

import com.springboot.hibernatejpa.dao.InstructorDAO;
import com.springboot.hibernatejpa.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class HibernatejpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatejpaApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(InstructorDAO instructorDAO){
		return runner -> {
			//createInstructor(instructorDAO);
			//findInstructor(instructorDAO);
			//deleteInstructor(instructorDAO);
			//findInstructorDetail(instructorDAO);
			//deleteInstructorDetail(instructorDAO);

			//createInstructorWithCourses(instructorDAO);
			//findInstructorWithCourses(instructorDAO);
			//findCoursesForInstructor(instructorDAO);
			//findInstructorWithCoursesJoinFetch(instructorDAO);
			//updateInstructor(instructorDAO);
			//updateCourse(instructorDAO);
			//deleteInstructorById(instructorDAO);
			//deleteCourseById(instructorDAO);

			//createInstructorWithCoursesAndWithCoursesReview(instructorDAO);
			//retrieveCourseAndReviews(instructorDAO);
			//deleteCourseAndReviews(instructorDAO);
			
			createCourseAndStudents(instructorDAO);

		};
	}

	private void createCourseAndStudents(InstructorDAO instructorDAO) {

		Course course = new Course("Python");

		Student student1 = new Student("Adem", "Kaya", "adem@gmail.com");
		Student student2 = new Student("Mehmet", "Can", "mehmet@gmail.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course : " + course);
		System.out.println("associated students : " + course.getStudents());

		instructorDAO.saveCourse(course);
	}

	private void deleteCourseAndReviews(InstructorDAO instructorDAO) {
		int id=11;

		System.out.println("Deleting course id : " + id);

		instructorDAO.deleteCourseById(id);
	}

	private void retrieveCourseAndReviews(InstructorDAO instructorDAO) {
		int id=18;

		Course course = instructorDAO.findCourseAndReviewByCourseId(id);

		System.out.println(course);
		System.out.println(course.getReviews());
	}

	private void createInstructorWithCoursesAndWithCoursesReview(InstructorDAO instructorDAO) {
		Instructor theInstructor = new Instructor("Salih", "Tutuncu", "salih@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("youtube.com/salih", "video games");

		Course course1 = new Course("Learn the Java");
		Course course2 = new Course("Learn the SpringBoot");
		Course course3 = new Course("Learn the MicroServices");

		course1.addReview(new Review("Basic"));
		course1.addReview(new Review("Sapik"));
		course2.addReview(new Review("Manyak"));

		theInstructor.add(course1);
		theInstructor.add(course2);
		theInstructor.add(course3);

		theInstructor.setInstructorDetail(theInstructorDetail);

		System.out.println("Saving instructor : " + theInstructor);
		System.out.println("The courses : " + theInstructor.getCourses());

		instructorDAO.save(theInstructor);

		System.out.println("Done!!!!!!!");
	}

	private void deleteCourseById(InstructorDAO instructorDAO) {

		int id=19;
		System.out.println("Deleting course id:  " + id);
		instructorDAO.deleteCourseById(id);
	}

	private void deleteInstructorById(InstructorDAO instructorDAO) {
		int id=4;
		instructorDAO.deleteInstructorById(id);
	}

	private void updateCourse(InstructorDAO instructorDAO) {

		int id=19;

		Course course = instructorDAO.findCourseById(id);

		course.setTitle("Selenium is very basic");
		instructorDAO.updateCourse(course);

	}

	private void updateInstructor(InstructorDAO instructorDAO) {

		int id=4;
		Instructor instructor = instructorDAO.findInstructorById(id);
		instructor.setLastName("Bulut");
		instructorDAO.updateInstructor(instructor);
	}

	private void findInstructorWithCoursesJoinFetch(InstructorDAO instructorDAO) {

		int id=1;

		System.out.println("Finding Instructor id: " + id);
		Instructor instructor = instructorDAO.findInstructorByIdJoinFetch(id);

		System.out.println("Instructor : " + instructor);
		System.out.println("the associated courses : " + instructor.getCourses());

	}

	private void findCoursesForInstructor(InstructorDAO instructorDAO) {
		int id=2;

		Instructor instructor = instructorDAO.findInstructorById(id);
		System.out.println("Instructor  : " + instructor);

		List<Course> courses = instructorDAO.findCoursesByInstructorId(id);

		instructor.setCourses(courses);

		System.out.println("Courses : " + instructor.getCourses());
	}

	private void findInstructorWithCourses(InstructorDAO instructorDAO) {

		int id=1;
		System.out.println("Finding instructor id: " + id);

		Instructor theInstructor = instructorDAO.findInstructorById(id);
		System.out.println("Instractor : " + theInstructor);
		System.out.println("Courses : " + theInstructor.getCourses());
	}

	private void createInstructorWithCourses(InstructorDAO instructorDAO) {

		Instructor theInstructor = new Instructor("Elif", "Yildirim", "elif@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("youtube.com/elif", "lazy");

		theInstructor.add(new Course("Learn the Testing"));
		theInstructor.add(new Course("Learn the UFT"));
		theInstructor.add(new Course("Learn the Selenium"));

		theInstructor.setInstructorDetail(theInstructorDetail);

		System.out.println("Saving instructor : " + theInstructor);
		System.out.println("The courses : " + theInstructor.getCourses());

		instructorDAO.save(theInstructor);

		System.out.println("Done!!!!!!!");
	}

	private void deleteInstructorDetail(InstructorDAO instructorDAO) {
		int id=5;
		instructorDAO.deleteInstructorDetail(id);
	}

	private void findInstructorDetail(InstructorDAO instructorDAO) {
		int id=1;
		InstructorDetail instructorDetail = instructorDAO.findInstructorDetailById(id);
		System.out.println("Instuctor Detail : " + instructorDetail);
		System.out.println("Instructor : " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(InstructorDAO instructorDAO) {
		int id = 3;
		System.out.println("Deleting instructor id: " + id);
		instructorDAO.deleteInstructor(id);

	}

	private void findInstructor(InstructorDAO instructorDAO) {

		int id = 1;
		System.out.println("Finding instructor id: " + id);
		Instructor theInstructor = instructorDAO.findInstructorById(id);
		System.out.println("Instructor : " + theInstructor);
		System.out.println("the associated instructorDetail only : " + theInstructor.getInstructorDetail());


	}

	private void createInstructor(InstructorDAO instructorDAO) {

		Instructor theInstructor = new Instructor("Salih", "Tütüncü", "salih@gmail.com");
		InstructorDetail theInstructorDetail = new InstructorDetail("youtube.com/salihim", "hang out");

		theInstructor.setInstructorDetail(theInstructorDetail);


		System.out.println("Saving instructor : " + theInstructor);
		instructorDAO.save(theInstructor);
		System.out.println("Done!!!!");


	}


}
