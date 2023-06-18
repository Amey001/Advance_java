package dao;

import static utils.HibbernateUtils.getFactory;

import org.hibernate.*;


import pojos.Employee;

public class EmpdaoImpl implements EmpDao{

	@Override
	public String insertEmplderails(Employee emp) {
		
		String mesg=" Adding data in database failed !!! ";
		Session session=getFactory().openSession();
		Transaction tx=session.beginTransaction();
		try {
			session.save(emp);
			tx.commit();
			mesg=" Added in database "+emp.getEmpId();
		}
		catch(RuntimeException e)
		{
			if(tx != null)
				tx.rollback();
		}
		finally {
			if(session != null )
				session.close();
		}
		return mesg;
	}

}
