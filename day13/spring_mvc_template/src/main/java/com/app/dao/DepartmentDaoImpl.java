package com.app.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.pojos.Department;

@Repository  //Manditory annotation to tell SC ::following is a spring bean containing Data access logic

public class DepartmentDaoImpl implements DepartmentDao{
	//dependency :: SessionFactory...we want loose coupling using IOC i.e D.I
	@Autowired //manditory dependency why? ->required=true,field level D.I
	private SessionFactory sf;	//auto. supplied by spring supplied :LocalSessionFactoryBean
		
	@Override
	public List<Department> getdepartmentlist() {
	
		//complete reduction of boiler plate code of dao layer
		return sf.getCurrentSession()
				.createQuery("select d from Department d",Department.class)
				.getResultList();

	}

}
