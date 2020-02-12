package com.madushan.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.madushan.app.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

}
