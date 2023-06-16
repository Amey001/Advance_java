package tester;
import static utils.Hibernateutils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;


public class RegisterStudent {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);)
		{
			StudentDaoImpl dao=new StudentDaoImpl();
//			String firstname, String lastname, String email, String password, Course course,
//			LocalDate dob
			System.out.println(" Enter firstname,lastname,email,password,course,Date of Birth :: ");
			Student student=new Student(sc.next(), sc.next(),sc.next(), sc.next()
					,Course.valueOf(sc.next()),LocalDate.parse(sc.next()));
			System.out.println(dao.insertStudent(student));	
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
	}

}
