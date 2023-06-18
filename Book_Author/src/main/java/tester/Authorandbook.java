package tester;

import org.hibernate.*;
import static utils.HibernateUtils.getFactory;

import java.util.Scanner;

import pojos.Author;
import pojos.Book;

public class Authorandbook {

	public static void main(String[] args) {
		
		try(SessionFactory sf=getFactory();
				Scanner sc=new Scanner(System.in);)
		{
			System.out.println(" enter the new author details :: firstname,lastname,email,password ");
			Author auth=new Author(sc.next(), sc.next(),sc.next(),sc.next());
			
			for(int i=0;i<3;i++)
			{
				System.out.println(" enter book details --> title and price ::");
				Book newbook=new Book(sc.next(),sc.nextDouble());
				System.out.println(auth.addnewBook(newbook));
			}
		}
		catch(Exception e)
		{
			System.out.println("error occured is :: "+e.getMessage());
			
		}
		
		

	}

}
