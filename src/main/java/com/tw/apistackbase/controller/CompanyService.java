package com.tw.apistackbase.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.stereotype.Service;

@Service
public class CompanyService {
	
	private static List<Employee>  employees = new ArrayList<Employee>() {
		{
			add(new Employee(1, "xiaohong", 20, "female", 7000));
			add(new Employee(2, "xiaoming", 22, "male", 8000));
			add(new Employee(3, "xiaogang", 20, "female", 9000));
			add(new Employee(4, "xiaoling", 20, "male", 7000));
			add(new Employee(5, "xiaoning", 20, "female", 6000));
		}
		
	};
	
	private static List<Company> companies = new ArrayList<Company>() {
		{
			add(new Company("ZYYH", 20000, employees));
			add(new Company("ZZYH", 10000, employees));
			add(new Company("RMYH", 30000, employees));
			
		}
	};
	public List<Employee> queryCompanyEmployees(String companyname) {
		List<Employee>  employeeList = new ArrayList<Employee>();
	
		for(Company item: companies) {
			if(item.getCompanyName() == companyname) {
				employeeList.addAll(item.getEmployees());
			}
		}			
		return employeeList;		
	}
	
	public Company addCompany(Company company) {
		companies.add(company);
		return company;			
	}

	public Company updateCompany(Company company) {
		Company companyRtn = new Company();
		for(Company item: companies) {
			if(item.getCompanyName() == company.getCompanyName()) {
				companyRtn = company;
			}
		}
		return companyRtn;	
	}

	public Boolean deleteCompany(Company company) {
		Boolean flag = false;
		for(Company item: companies) {
			if(item.getCompanyName() == company.getCompanyName()) {
				companies.remove(company);
				flag = true;
			}
		}
		return flag;	
		
	}
	
	
}
