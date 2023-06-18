package dao;


import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;
import pojos.Book;

public class Bookdaoimpl implements Bookdao{

	@Override
	public String registerBook(Book newbook, String aemail) {
		String mesg=" registration failed !!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		String jpql="select a from Author a where email=:em";
		Author newauthor=new Author();
		try {
			newauthor=session.createQuery(jpql,Author.class)
			.setParameter("em", aemail)
			.getSingleResult();
			 if(newauthor != null)
			 {
//				 newauthor.getBooklist()
//				 .add(newbook);
//			 	newbook.setBookauthor(newauthor); 
				 newauthor.addnewBook(newbook);
			 }
 
			tx.commit();
			
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
		}
		return null;
	}

}
