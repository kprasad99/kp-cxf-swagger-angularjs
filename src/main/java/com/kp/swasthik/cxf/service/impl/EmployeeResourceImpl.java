package com.kp.swasthik.cxf.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kp.swasthik.cxf.db.dao.EmployeeRepo;
import com.kp.swasthik.cxf.db.domain.Employee;
import com.kp.swasthik.cxf.service.EmployeeResource;

@Service
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	private EmployeeRepo empRepo;

	@Override
	public boolean addAll(List<Employee> employees) {
		empRepo.save(employees);
		return true;
	}

	@Override
	public List<Employee> getAll() {
		return StreamSupport.stream(empRepo.findAll().spliterator(), true).collect(Collectors.toList());
	}

	@Override
	public boolean add(int empId, Employee employee) {
		empRepo.save(employee);
		return true;
	}

	@Override
	public Employee get(int empId) {
		return empRepo.findOne(empId);
	}

	@Override
	public int updateAge(int empId, int age) {
		
		return empRepo.updateAge(empId, age);
	}

}
