package main;

import org.mongodb.morphia.Morphia;
import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.dao.BasicDAO;
import dao.StudentDAO;
import dao.CourseDAO;
import dao.TeacherDAO;
import dao.NotesDAO;
import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.Notes;
import java.util.*;

public class Main {
	public static void main(String args[]){
		MongoClient mongo= new MongoClient("localhost", 27017);
		Morphia morphia= new Morphia();
		Datastore datastore= morphia.createDatastore(mongo, "highschool");
		morphia.mapPackage("main");
		
		//init DAOs
		
		StudentDAO studentDAO= new StudentDAO(morphia, mongo);
		CourseDAO courseDAO= new CourseDAO(morphia, mongo);
		TeacherDAO teacherDAO= new TeacherDAO(morphia, mongo);
		NotesDAO notesDAO= new NotesDAO(morphia, mongo);
		
		//Courses
		
		Course course1= new Course();
		course1.setCourseName("Math");
		course1.setHoursPerWeek(8);
		List<String> schedule1= new ArrayList();
		schedule1.add(0, "Wednesday 09:00 - 13:00");
		schedule1.add(0, "Monday 09:00 - 13:00");
		course1.setSchedule(schedule1);
		courseDAO.save(course1);
		
		Course course2= new Course();
		course2.setCourseName("History");
		course2.setHoursPerWeek(6);
		List<String> schedule2= new ArrayList();
		schedule1.add(0, "Thursday 09:00 - 11:00");
		schedule1.add(0, "Tuesday 09:00 - 13:00");
		course2.setSchedule(schedule2);
		courseDAO.save(course2);
		
		Course course3= new Course();
		course3.setCourseName("Geography");
		course3.setHoursPerWeek(6);
		List<String> schedule3= new ArrayList();
		schedule3.add(0, "Friday 09:00 - 13:00");
		schedule3.add(0, "Thursday 11:00 - 13:00");
		course3.setSchedule(schedule3);
		courseDAO.save(course3);
		
		//Teachers
		
		Teacher teacher1 = new Teacher();
        teacher1.setFirstname("Pedro");
        teacher1.setLastname("Almodovar");
        teacher1.setDateOfBirth("1987-04-25");
        List<Course> coursesList1 = new ArrayList();
        coursesList1.add(course1);
        coursesList1.add(course2);
        teacher1.setAssignedCourses(coursesList1);
        teacherDAO.save(teacher1);
        
        Teacher teacher2 = new Teacher();
        teacher2.setFirstname("Cristiano");
        teacher2.setLastname("Ronaldo");
        teacher2.setDateOfBirth("1988-05-26");
        List<Course> coursesList2 = new ArrayList();
        coursesList2.add(course2);
        teacher2.setAssignedCourses(coursesList2);
        teacherDAO.save(teacher2);
        
        Teacher teacher3 = new Teacher();
        teacher3.setFirstname("Richie");
        teacher3.setLastname("McCaw");
        teacher3.setDateOfBirth("1989-09-27");
        List<Course> coursesList3 = new ArrayList();
        coursesList3.add(course3);
        teacher3.setAssignedCourses(coursesList3);
        teacherDAO.save(teacher3);
        
        //Students
        
        Student student1 = new Student();
        student1.setFirstname("Carlos");
        student1.setLastname("I");
        student1.setDateOfBirth("1991-10-22");
        studentDAO.save(student1);

        Student student2 = new Student();
        student2.setFirstname("Carlos");
        student2.setLastname("II");
        student2.setDateOfBirth("1992-10-22");
        studentDAO.save(student2);

        Student student3 = new Student();
        student3.setFirstname("Carlos");
        student3.setLastname("III");
        student3.setDateOfBirth("1993-10-22");
        studentDAO.save(student3);

        Student student4 = new Student();
        student4.setFirstname("Carlos");
        student4.setLastname("IV");
        student4.setDateOfBirth("1994-10-22");
        studentDAO.save(student4);

        Student student5 = new Student();
        student5.setFirstname("Carlos");
        student5.setLastname("V");
        student5.setDateOfBirth("1995-10-22");
        studentDAO.save(student5);

        Student student6 = new Student();
        student6.setFirstname("Carlos");
        student6.setLastname("VI");
        student6.setDateOfBirth("1996-10-22");
        studentDAO.save(student6);

        Student student7 = new Student();
        student7.setFirstname("Carlos");
        student7.setLastname("VII");
        student7.setDateOfBirth("1997-10-22");
        studentDAO.save(student7);

        Student student8 = new Student();
        student8.setFirstname("Carlos");
        student8.setLastname("VIII");
        student8.setDateOfBirth("1998-10-22");
        studentDAO.save(student8);

        Student student9 = new Student();
        student9.setFirstname("Carlos");
        student9.setLastname("IX");
        student9.setDateOfBirth("1999-10-22");
        studentDAO.save(student9);

        Student student10 = new Student();
        student10.setFirstname("Carlos");
        student10.setLastname("X");
        student10.setDateOfBirth("2000-10-22");
        studentDAO.save(student10);

        Student student11 = new Student();
        student11.setFirstname("Pio");
        student11.setLastname("I");
        student11.setDateOfBirth("2001-10-22");
        studentDAO.save(student11);

        Student student12 = new Student();
        student12.setFirstname("Pio");
        student12.setLastname("II");
        student12.setDateOfBirth("2002-10-22");
        studentDAO.save(student12);

        Student student13 = new Student();
        student13.setFirstname("Pio");
        student13.setLastname("III");
        student13.setDateOfBirth("2003-10-22");
        studentDAO.save(student13);

        Student student14 = new Student();
        student14.setFirstname("Pio");
        student14.setLastname("IV");
        student14.setDateOfBirth("2004-10-22");
        studentDAO.save(student10);

        Student student15 = new Student();
        student15.setFirstname("Pio");
        student15.setLastname("V");
        student15.setDateOfBirth("2005-10-22");
        studentDAO.save(student15);

        Student student16 = new Student();
        student16.setFirstname("Pio");
        student16.setLastname("VI");
        student16.setDateOfBirth("2006-10-22");
        studentDAO.save(student16);

        Student student17 = new Student();
        student17.setFirstname("Pio");
        student17.setLastname("VII");
        student17.setDateOfBirth("2007-10-22");
        studentDAO.save(student17);

        Student student18 = new Student();
        student18.setFirstname("Pio");
        student18.setLastname("VIII");
        student18.setDateOfBirth("2008-10-22");
        studentDAO.save(student18);

        Student student19 = new Student();
        student19.setFirstname("Pio");
        student19.setLastname("IX");
        student19.setDateOfBirth("2009-10-22");
        studentDAO.save(student19);

        Student student20 = new Student();
        student20.setFirstname("Pio");
        student20.setLastname("X");
        student20.setDateOfBirth("2010-10-22");
        studentDAO.save(student20);

        Student student21 = new Student();
        student21.setFirstname("Augusto");
        student21.setLastname("I");
        student21.setDateOfBirth("2011-10-22");
        studentDAO.save(student21);

        Student student22 = new Student();
        student22.setFirstname("Augusto");
        student22.setLastname("II");
        student22.setDateOfBirth("2012-10-22");
        studentDAO.save(student22);

        Student student23 = new Student();
        student23.setFirstname("Augusto");
        student23.setLastname("III");
        student23.setDateOfBirth("2013-10-22");
        studentDAO.save(student23);

        Student student24 = new Student();
        student24.setFirstname("Augusto");
        student24.setLastname("IV");
        student24.setDateOfBirth("2014-10-22");
        studentDAO.save(student24);

        Student student25 = new Student();
        student25.setFirstname("Augusto");
        student25.setLastname("V");
        student25.setDateOfBirth("2015-10-22");
        studentDAO.save(student25);

        Student student26 = new Student();
        student26.setFirstname("Augusto");
        student26.setLastname("VI");
        student26.setDateOfBirth("2016-10-22");
        studentDAO.save(student26);

        Student student27 = new Student();
        student27.setFirstname("Augusto");
        student27.setLastname("VII");
        student27.setDateOfBirth("2017-10-22");
        studentDAO.save(student27);

        Student student28 = new Student();
        student28.setFirstname("Augusto");
        student28.setLastname("VIII");
        student28.setDateOfBirth("2018-10-22");
        studentDAO.save(student28);

        Student student29 = new Student();
        student29.setFirstname("Augusto");
        student29.setLastname("IX");
        student29.setDateOfBirth("2019-10-22");
        studentDAO.save(student29);

        Student student30 = new Student();
        student30.setFirstname("Augusto");
        student30.setLastname("X");
        student30.setDateOfBirth("2020-10-22");
        studentDAO.save(student30);
		
		//Notes
        
        Notes note1 = new Notes();
        note1.setCourse(course1);
        note1.setStudent(student1);
        note1.setFirstNote(6);
        note1.setSecondNote(7);
        note1.setThirdNote(8);
        note1.setFinalNote(7.0d);
        notesDAO.save(note1);
        
        Notes note2 = new Notes();
        note2.setCourse(course1);
        note2.setStudent(student2);
        note2.setFirstNote(5);
        note2.setSecondNote(9);
        note2.setThirdNote(9);
        note2.setFinalNote(7.66d);
        notesDAO.save(note2);
        
        Notes note3 = new Notes();
        note3.setCourse(course1);
        note3.setStudent(student3);
        note3.setFirstNote(7);
        note3.setSecondNote(7);
        note3.setThirdNote(7);
        note3.setFinalNote(7.0d);
        notesDAO.save(note3);
        
        Notes note4 = new Notes();
        note4.setCourse(course1);
        note4.setStudent(student4);
        note4.setFirstNote(2);
        note4.setSecondNote(2);
        note4.setThirdNote(2);
        note4.setFinalNote(2.0d);
        notesDAO.save(note4);
        
        Notes note5 = new Notes();
        note5.setCourse(course2);
        note5.setStudent(student5);
        note5.setFirstNote(3);
        note5.setSecondNote(4);
        note5.setThirdNote(5);
        note5.setFinalNote(4.0d);
        notesDAO.save(note5);
        
        Notes note6 = new Notes();
        note6.setCourse(course2);
        note6.setStudent(student6);
        note6.setFirstNote(10);
        note6.setSecondNote(10);
        note6.setThirdNote(10);
        note6.setFinalNote(10.0d);
        notesDAO.save(note6);
        
        Notes note7 = new Notes();
        note7.setCourse(course2);
        note7.setStudent(student7);
        note7.setFirstNote(2);
        note7.setSecondNote(7);
        note7.setThirdNote(2);
        note7.setFinalNote(3.66d);
        notesDAO.save(note7);
        
        Notes note8 = new Notes();
        note8.setCourse(course2);
        note8.setStudent(student8);
        note8.setFirstNote(2);
        note8.setSecondNote(9);
        note8.setThirdNote(8);
        note8.setFinalNote(6.33d);
        notesDAO.save(note8);
        
        Notes note9 = new Notes();
        note9.setCourse(course3);
        note9.setStudent(student9);
        note9.setFirstNote(3);
        note9.setSecondNote(7);
        note9.setThirdNote(1);
        note9.setFinalNote(3.66d);
        notesDAO.save(note9);
        
        Notes note10 = new Notes();
        note10.setCourse(course3);
        note10.setStudent(student10);
        note10.setFirstNote(3);
        note10.setSecondNote(9);
        note10.setThirdNote(10);
        note10.setFinalNote(7.33d);
        notesDAO.save(note10);
        
        Notes note11 = new Notes();
        note11.setCourse(course3);
        note11.setStudent(student11);
        note11.setFirstNote(10);
        note11.setSecondNote(7);
        note11.setThirdNote(4);
        note11.setFinalNote(7.0d);
        notesDAO.save(note11);
        
        Notes note12 = new Notes();
        note12.setCourse(course3);
        note12.setStudent(student12);
        note12.setFirstNote(2);
        note12.setSecondNote(2);
        note12.setThirdNote(2);
        note12.setFinalNote(2.0d);
        notesDAO.save(note12);
        
        //practice 2
        
        List<Student> listAux= new ArrayList();
        listAux= notesDAO.practice2(course1);
        
        System.out.println("Practice 2: Students that scored at least 4 in a given course \n");
        
        for(int i=0; i<listAux.size(); i++){
        	Student stu= listAux.get(i);
        	System.out.printf("\t%s, %s\n", stu.getLastname(), stu.getFirstname());
        	
        }
        System.out.printf("\n\n");
        
        //practice 3
        
        List<Course> mcCawCourses= new ArrayList();
        mcCawCourses= teacherDAO.practice3(teacher3);
        
        System.out.printf("\n\nCourses given by %s %s:\n\n", teacher1.getFirstname(), teacher1.getLastname());
        
        for(int i=0; i<mcCawCourses.size(); i++){
        	Course cou= mcCawCourses.get(i);
        	System.out.printf("\n\t%s\n", cou.getCourseName());
        	
        }
        System.out.printf("\n\n");
        
		
		
		
	}
}
