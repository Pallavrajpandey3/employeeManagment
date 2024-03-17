package com.pallav.EmployeeManagment.service;

import java.util.List;

import com.pallav.EmployeeManagment.employe.Employe;

public interface Empservice {
	public Employe saveEmp(Employe emp);
    
	public List<Employe> getAll();
    
    public Employe getEmpById(int id);
    
    public boolean deleteEmp(int id);
}
