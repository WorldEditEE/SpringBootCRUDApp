package com.ukolov.spring.boot.springbootcrudapp.repository;

import com.ukolov.spring.boot.springbootcrudapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

    public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
