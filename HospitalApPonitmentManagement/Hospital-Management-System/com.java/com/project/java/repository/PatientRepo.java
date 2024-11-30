package com.project.java.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.java.entity.Patient;

@Repository
public interface PatientRepo extends JpaRepository<Patient, Integer> {

}
