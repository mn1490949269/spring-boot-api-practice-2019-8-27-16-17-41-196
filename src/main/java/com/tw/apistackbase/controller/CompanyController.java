package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	private CompanyService companyService;

		
	@GetMapping("/1/employees")
	public ResponseEntity<List<Employee>> queryCompanyEmployees(@RequestParam String companyname) {
		List<Employee> employees = companyService.queryCompanyEmployees(companyname);
		return ResponseEntity.ok(employees);
	}
	
	@PostMapping
	public ResponseEntity<Company> addCompany(@RequestBody Company company) {
		companyService.addCompany(company);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	@PutMapping("/1")
	public ResponseEntity<Company> updateCompany(Company company){
		companyService.updateCompany(company);
		return ResponseEntity.status(HttpStatus.OK).build();
	}
	@DeleteMapping("/1")
	public ResponseEntity<Boolean> deleteCompany(Company company){
		companyService.deleteCompany(company);
		return ResponseEntity.status(HttpStatus.OK).build();
	}	

}
