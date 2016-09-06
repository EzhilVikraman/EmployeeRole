package com.compass;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.lang.String;
import com.compass.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	List<Employee> findById(long id);
	List<Employee> findByRole(String role);
	List<Employee> findByUsername(String username);

}
