package tester;

import java.util.Scanner;
import static utils.HibernateUtils.getFactory;
import org.hibernate.*;

import dao.Authordaoimpl;
import pojos.Author;

public class AddnewAuthor{

	public static void main(String[] args) {
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);
				)
		{
			System.out.println(" Register new Author :: firstname,lastname,email,passwword :: ");
			Author one=new Author(sc.next(),sc.next(), sc.next(),sc.next());
			Authordaoimpl a=new Authordaoimpl();
			a.registernewAuthor(one);
			
		}

	}

}
