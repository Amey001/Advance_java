package tester;

import org.hibernate.*;

import dao.EmpdaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibbernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class AddEmployee {
	public static void main(String[] args) {

		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in))
		{
			EmpdaoImpl dao=new EmpdaoImpl();
//			/*
//			 * emp_id(PK) ,first_name,last_name,email(unique),
//			 * password,confir,passwd,join_date,emp_type(full_time/part_time/contract...)
//			 * salary
//			 */
			System.out.println(" Enter firstname,lastname,email,password,con,join date,emptype,salary");
			Employee newemp=new Employee(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),EmploymentType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
			
			String message=dao.insertEmplderails(newemp);
			System.out.println(message);
			
		}
		
	}
}
