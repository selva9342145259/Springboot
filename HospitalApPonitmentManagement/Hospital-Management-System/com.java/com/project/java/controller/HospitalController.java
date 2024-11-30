package com.project.java.controller;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.java.entity.Patient;
import com.project.java.service.PatientService;

import jakarta.servlet.http.HttpSession;

@Controller
public class HospitalController {
	
	@Autowired
	private PatientService service;
	
	@GetMapping("/")
	public String home() {    //Homepage
		return "index";		 // it will show the index page
	}
	
	@GetMapping("/addPatient") 			// url mapping
	public String addPatientForm() {
		return "add_Patient";
	}
	
	@GetMapping("/showDoctor")
	public String showDoctorTable(Model m) {
		List<Patient> patient = service.getAllPatient();
		m.addAttribute("patient",patient);
		return "show_Doctor";
	}
	
	@PostMapping("/register")
	public String patientRegister(@ModelAttribute Patient p) {
		System.out.println(p);
		return service.addPatient(p);
	}
	
	@GetMapping("/update/{id}")
	public String update(@PathVariable int id, Model m) {
		Patient p = service.getPatientById(id);
		m.addAttribute("patient", p);
		return "update";	
	}
	
	@PostMapping("/modify")
	public String modifyPatient(@ModelAttribute Patient p, HttpSession session) {
		service.addPatient(p);
		session.setAttribute("msg", "Patient Data Updated Successfully");
		return "redirect:/";
		
	}
	
	@GetMapping("/delete/{id}")
	public String deletePatient(@PathVariable int id, HttpSession session) {
		service.deletePatient(id);
		session.setAttribute("msg", "Patient Data Deleted Successfully");
		return "redirect:/";

		
	}
	
	
	

}
