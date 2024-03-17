package com.pallav.EmployeeManagment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.pallav.EmployeeManagment.employe.Employe;
import com.pallav.EmployeeManagment.service.Empservice;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {
    @Autowired
    private Empservice emps;
	
	@GetMapping("/")
	public String index(Model m)
	{
	   List<Employe> list=emps.getAll();
		m.addAttribute("empList", list);
		return "index";
	}
	@GetMapping("/emp_save")
	public String emp_save()
	{
		return "emp_save";
	}
	@GetMapping("/emp_edit/{id}")
	public String emp_edit(@PathVariable int id,Model m)
	{
		Employe emp=emps.getEmpById(id);
		m.addAttribute("emp", emp);
		return "emp_edit";
	}
	@PostMapping("/saveEmp")
	public String saveEmp(@ModelAttribute Employe emp,HttpSession http)
	{
		Employe em =emps.saveEmp(emp);
	   if(em==null)
	   {
		   http.setAttribute("msg", "Something went wrong...");
	   }
	   else
	   {
		   http.setAttribute("msg", "Resistred Sucessfully");
	   }
		return "redirect:/"; 
	}
    @PostMapping("/updateEmpDtls")
   public String empUpdate(@ModelAttribute Employe emp,HttpSession http)
    {
    	
    	Employe em =emps.saveEmp(emp);
    	   if(em==null)
    	   {
    		   http.setAttribute("msg", "Something went wrong...");
    	   }
    	   else
    	   {
    		   http.setAttribute("msg", "Update Sucessfully");
    	   }
    	return "redirect:/";
    }
    @GetMapping("/deletEmp/{id}")
    public String delet(@PathVariable int id,HttpSession http)
    {
    	boolean b=emps.deleteEmp(id);
    	if(b)
    		http.setAttribute("msg", "Deleted Sucessfull");
    	return "redirect:/";
    }
    
}

