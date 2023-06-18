package tester;

import org.hibernate.*;

import dao.Authordaoimpl;
import dao.Bookdaoimpl;
import pojos.Book;
import static utils.HibernateUtils.getFactory;
import java.util.Scanner; 

public class Addbookwritenbyauthor {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);)
		{
			Bookdaoimpl dao=new Bookdaoimpl();
			System.out.println(" Enter book details --> Title and price ::");
			Book newbook=new Book(sc.next(), sc.nextDouble());
			System.out.println(" enter the email of author :: ");
			System.out.println(" book add successfully :: "+dao.registerBook(newbook, sc.next()));
			
		}catch(RuntimeException e)
		{	
			System.out.println(e.getMessage());
		}

	}

}
