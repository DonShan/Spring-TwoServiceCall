package com.madushan.app.service;

import java.util.Optional;

import com.madushan.app.model.Allocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.madushan.app.model.Employee;
import com.madushan.app.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Bean
	RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Autowired
	RestTemplate restTemplate;

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee save(Employee e) {
		Employee employee = employeeRepository.save(e);
		return employee;
	}

	@Override
	public Employee findById(int id) {
		return employeeRepository.findById(id).get();
	}

	@Override
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return (id != 0) ? "Employee deleted with id:-" + id : "NO users";
	}

	@Override
	public Employee fethAllEmployees(int id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (employee.isPresent()) {

			HttpEntity<String> stringHttpEntity = new HttpEntity<>("", new HttpHeaders());

			Employee employee1 = employee.get();
			
			ResponseEntity<Allocation[]> responseEntity = restTemplate.exchange(
					"http://localhost:8081/services/getbyid/" + id, HttpMethod.GET, stringHttpEntity,
					Allocation[].class);
			employee1.setAllocations(responseEntity.getBody());
			return employee1;
		} else
			return null;
	}

}
