package tester;

import org.hibernate.*;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;
import static utils.HibernateUtils.getFactory;
import java.time.LocalDate;
import java.util.Scanner;

public class Addemptodepartment {
public static void main(String[] args) {
	
	try(SessionFactory sf=getFactory();
			Scanner sc=new Scanner(System.in);)
	{
//		firstName,lastName,email,password,joinDate,type,salary
		EmployeeDaoImpl dao=new EmployeeDaoImpl();
		System.out.println(" enter the employee details :: first name,last name,email,password,joining date,type,salary :: ");
		Employee emp=new Employee(sc.next(), sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),EmploymentType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
		System.out.println(" enter department details :: ");
		dao.addnewemp(emp, sc.nextLong());
		
	}
}
}
