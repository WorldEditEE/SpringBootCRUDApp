package com.ukolov.spring.boot.springbootcrudapp.service;

import com.ukolov.spring.boot.springbootcrudapp.model.Employee;
import com.ukolov.spring.boot.springbootcrudapp.repository.EmployeeRepository;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public Employee findById(int id){

        return employeeRepository.getById(id);
    }

    public List<Employee> findAll(){

        return employeeRepository.findAll();
    }
    public Employee saveEmployee(Employee employee){

        return employeeRepository.save(employee);
    }
    public void deleteById(int id){

        employeeRepository.deleteById(id);
    }


}
