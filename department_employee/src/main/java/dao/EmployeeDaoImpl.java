package dao;

import static utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import pojos.Department;
import pojos.Employee;

public class EmployeeDaoImpl implements EmployeeDao{

	@Override
	public String addnewemp(Employee emp, long id) {
		
		String mesg=" Department launching failed !!!";
		Session session=getFactory().getCurrentSession();
		Transaction tx=session.beginTransaction();
		Department dept=null;
		try {
			dept=session.get(Department.class, id);
			if(dept!=null)
//				dept.getEmpList().add(emp);
//				emp.setAssignedDept(dept);
				dept.AddnewEmp(emp);
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
