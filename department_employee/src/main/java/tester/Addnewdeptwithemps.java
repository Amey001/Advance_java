package tester;

import org.hibernate.*;

import pojos.Department;
import pojos.Employee;
import pojos.EmploymentType;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;

public class Addnewdeptwithemps {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);)
		{
			System.out.println(" enter department details department name and location :: ");
			Department dept=new Department(sc.next(),sc.next());
			for(int i=0;i<2;i++)
			{
				System.out.println(" enter the employee details :: first name,last name,email,password,joining date,type,salary :: ");
				Employee emp=new Employee(sc.next(), sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),EmploymentType.valueOf(sc.next().toUpperCase()),sc.nextDouble());
				dept.AddnewEmp(emp);
				
			}
			System.out.println(" employees has been added to new Department :: "+dept.getDepartmentName());
		}

	}

}
