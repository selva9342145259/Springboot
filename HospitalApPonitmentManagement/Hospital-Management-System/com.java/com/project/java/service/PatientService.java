package com.project.java.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.java.entity.Patient;
import com.project.java.repository.PatientRepo;


@Service
public class PatientService {
	
	@Autowired
	private PatientRepo repo;
	
	public String addPatient(Patient p) {
	List<Patient> check=repo.findAll();
		boolean ch=check.stream().noneMatch(c -> p.getTime().equals(c.getTime())&&p.getDate().equals(c.getDate()));
	if(ch)  {
		repo.save(p);
		return "show_Doctor";
	} else {
		return "update";
	}	
	}
	
	public List<Patient> getAllPatient(){
		return repo.findAll();
	}
	
	public Patient getPatientById(int id) {
		Optional<Patient> p = repo.findById(id);
		if(p.isPresent()) {
			return p.get();
		}
		return null;
	}
	
	public void deletePatient(int id) {
		repo.deleteById(id);
	}
}
