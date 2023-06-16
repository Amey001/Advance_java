package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.Hibernateutils.getFactory;

import pojos.Student;

public class StudentDaoImpl implements StudentDao{

	@Override
	public String insertStudent(Student student) {
		
		String mesg=" Student registration failed !!!";
		
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		
		try
		{
			session.save(student);
			tx.commit();
			mesg=" student registered succesfully with "+student.getStudentid();
		}
		catch(RuntimeException e)
		{
			if(tx!=null)
				tx.rollback();
			throw e;
		}
				
		return mesg;
	}

	@Override
	public String StudLogin(String email, String pass) {
		
		String msg="login failed...";
		String jpql="Select s from student s where s.email=:smail and s.pass=:spassword";
		Session session=getFactory().getCurrentSession();
		Student stud=null;
		Transaction tx=session.beginTransaction();
		try {
			stud=session.createQuery(jpql, String.class)
					.setParameter("smail", email).setParameter("spassword", pass)
					.getSingleResult();
		}
		
	}

}
