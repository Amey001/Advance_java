package tester;

import org.hibernate.SessionFactory;

import dao.EmployeeDaoImpl;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.Hibernateutils.getFactory;


import java.time.LocalDate;
import java.util.Scanner;

public class GetEmployeeDetails {

	public static void main(String[] args) {
		try (SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)) // invoking static method -->
		// cls loading --> static init block --> configure : entire hib frmwork loaded
		{
			//create dao instance
			EmployeeDaoImpl dao=new EmployeeDaoImpl();
			System.out.println("Enter emp id");
			
			System.out.println(dao.getEmpDetails(sc.nextInt()));
			
		} // sf.close() --> cleaning up DBCP (db conn pool)
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
