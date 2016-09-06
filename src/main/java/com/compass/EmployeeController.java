package com.compass;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.compass.customexception.ConstraintViolated;
import com.compass.customexception.DuplicateEntry;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	public EmployeeController(EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@RequestMapping(value = "/getall", method = RequestMethod.GET)
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)

	public String create(@RequestBody Employee employee) throws DuplicateEntry, ConstraintViolated {
		try {
			employeeRepository.save(employee);
			// return employeeRepository.findAll();
			return "employee added successfully";
		}

		catch (DataIntegrityViolationException e) {

			throw new DuplicateEntry("user already exist");

		} catch (ConstraintViolationException e) {

			throw new ConstraintViolated("size must be entered between 3 and 20");

		}

		/*
		 * catch (DataIntegrityViolationException e) {
		 * 
		 * String role = employee.getRole(); String employeename =
		 * employee.getUsername();
		 * 
		 * return "employee named " + employeename +
		 * " already exists and his role is " + role; } catch
		 * (javax.validation.ConstraintViolationException e) { ValidatorFactory
		 * factory = Validation.buildDefaultValidatorFactory(); Validator
		 * validator = factory.getValidator();
		 * Set<ConstraintViolation<Employee>> constraints =
		 * validator.validate(employee); for (ConstraintViolation<Employee>
		 * constraint : constraints) {
		 * System.out.println(constraint.getPropertyPath() + "  " +
		 * constraint.getMessage()); String msg = constraint.getMessage(); }
		 * //String msg=constraints.; return "msg"; }
		 */

	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public String deleteEmployee(@PathVariable long id) {
		try {
			employeeRepository.delete(id);
		} catch (Exception ex) {
			return "Error deleting the user: "+String.valueOf(id) ;
		}
		return "User succesfully deleted!";
	}

	@RequestMapping(value = "/find/id/{id}", method = RequestMethod.GET)
	public String findEmployeeById(@PathVariable long id) {

		List<Employee> em = employeeRepository.findById(id);
		String name = em.get(0).getUsername();
		String role = em.get(0).getRole();

		return "Employee name is " + name + " and role is " + role;

	}

	@RequestMapping(value = "/find/username/{username}", method = RequestMethod.GET)
	public String findEmployeeByUserName(@PathVariable String username) {

		List<Employee> em = employeeRepository.findByUsername(username);
		long id = em.get(0).getId();
		String role = em.get(0).getRole();

		return "Employee ID is " + id + " and role is " + role;

	}

	@RequestMapping(value = "/find/role/{role}", method = RequestMethod.GET)
	public List<Employee> findEmployeeByRole(@PathVariable String role) {
		ArrayList names = new ArrayList<>();
		List<Employee> em = employeeRepository.findByRole(role);
		// String name = em.get(0).getUsername();
		for (Employee emp : em) {
			String name = emp.getUsername();
			names.add(emp.getUsername());
		}

		return names;

	}

}
