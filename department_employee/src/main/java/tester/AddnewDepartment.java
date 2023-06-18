package tester;

import org.hibernate.*;

import dao.DepartmentDaoImpl;
import pojos.Department;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class AddnewDepartment {

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);) 
		{
			//add new department to department table
			DepartmentDaoImpl dao=new DepartmentDaoImpl();
			System.out.println(" Enter the department name and location of the department :: ");
			Department dept=new Department(sc.next(),sc.next());
			System.out.println(dao.Launchnewdepartment(dept));
			
		}
	}
}
