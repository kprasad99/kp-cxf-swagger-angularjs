package com.kp.swasthik.cxf.db.dao;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.kp.swasthik.cxf.db.domain.Employee;

@Repository
@Transactional
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

	@Modifying
	@Query("update Employee e set e.age=?2 where e.empId=?1")
	int updateAge(int empId, int age);

}
