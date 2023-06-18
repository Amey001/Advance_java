package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Author;

public class Authordaoimpl implements AuthorDao{

	@Override
	public String registernewAuthor(Author a) {
		String mesg=" Registration failed !!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(a);
			tx.commit();
			mesg=" Registration successfull !!! ";
		}catch(RuntimeException e)
		{
			if(tx != null)
				tx.rollback();
			throw e;
		}
		
		
		
		return mesg;
	}

}
