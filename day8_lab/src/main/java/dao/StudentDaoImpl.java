package dao;

import org.hibernate.*;
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
		String jpql="select s from Student s where s.email=:mail1 and s.password=:pass1";
		Session session=getFactory().getCurrentSession();
		Student stud=null;
		Transaction tx=session.beginTransaction();
		try {
			System.out.println(" in try of studentDao");
			
			stud=session.createQuery(jpql, Student.class)
					.setParameter("mail1", email).setParameter("pass1", pass)
					.getSingleResult();
			
			tx.commit();
//			if(stud!=null)
				msg=" login Successfull Id :: "+stud.getStudentid();
			
		}
		catch(RuntimeException e)
		{
			System.out.println(" in catch of studentDao");
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

}
