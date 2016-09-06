package com.compass;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DatabaseAccess implements CommandLineRunner {

	private EmployeeRepository employeeRepository;

	@Autowired
	public DatabaseAccess(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@Override
	public void run(String... strings) throws Exception {
		
		/* List<Employee> employeeList = new ArrayList<>(); employeeList.add(new
		 Employee("raju", "intern")); employeeList.add(new Employee("kumar",
		 "software consultant")); employeeList.add(new Employee("Arpitha",
		 "developer"));
		 
		 employeeRepository.save(employeeList);
		 
		 */
	}
}
