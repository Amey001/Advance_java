package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.*;

import pojos.Department;

public class DepartmentDaoImpl implements DepartmentDao {

	@Override
	public String Launchnewdepartment(Department dept) {
		String mesg=" Department launching failed !!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try {
			session.persist(dept);
			tx.commit();
			mesg=" department launched succesfully !!1";
			
		}catch( RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		
		return mesg;
	}

}
