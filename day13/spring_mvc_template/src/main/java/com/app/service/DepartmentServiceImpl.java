package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.DepartmentDao;
import com.app.pojos.Department;

@Service //manditory anno to tell SC,following is a spring bean
//::containing B.L
@Transactional //manditory annotation to tell SC to manage the txs : automatically !!

public class DepartmentServiceImpl implements DepartmentService {

	//dependency : dao layer i/f
	@Autowired //by type : field level D.I
	private DepartmentDao dao;
	
	@Override
	public List<Department> getAllDepts() {
	
		return dao.getdepartmentlist();
	}

}
