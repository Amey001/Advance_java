package tester;

import org.hibernate.*;

import dao.StudentDaoImpl;
import pojos.Student;

import static utils.Hibernateutils.getFactory;

import java.util.Scanner;
public class Login {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);
				)
		{
			StudentDaoImpl st=new StudentDaoImpl();
			System.out.println("enter correct email,password ..");
			System.out.println(st.StudLogin(sc.next(), sc.next()));
			
			
		}

	}

}
