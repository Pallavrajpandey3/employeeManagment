package com.pallav.EmployeeManagment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.pallav.EmployeeManagment.employe.Employe;
import com.pallav.EmployeeManagment.repo.EmpRepo;

import jakarta.servlet.http.HttpSession;

@Service
public class EmpServiceImpl implements Empservice {

	@Autowired
	private EmpRepo emprepo;
	
	@Override
	public Employe saveEmp(Employe emp) {
		Employe em = emprepo.save(emp); 
		return em;
	}

	@Override
	public List<Employe> getAll() {
		
		return emprepo.findAll();
	}

	@Override
	public Employe getEmpById(int id) {
		
		return emprepo.findById(id).get();
	}

	@Override
	public boolean deleteEmp(int id) {
		Employe emp=emprepo.findById(id).get();
		if(emp!=null)
		{
			emprepo.delete(emp);
			return true;
		}
		return false;
	}
	public void removeSession()
	{
		 HttpSession session= ((ServletRequestAttributes)(RequestContextHolder.getRequestAttributes())).
		  getRequest().getSession();
	 session.removeAttribute("msg");


	}

}

