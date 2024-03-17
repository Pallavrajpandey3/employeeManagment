package com.pallav.EmployeeManagment.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pallav.EmployeeManagment.employe.Employe;

public interface EmpRepo extends JpaRepository<Employe, Integer> {

}
