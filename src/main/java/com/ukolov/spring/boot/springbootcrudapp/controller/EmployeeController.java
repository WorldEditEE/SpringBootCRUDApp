package com.ukolov.spring.boot.springbootcrudapp.controller;

import com.ukolov.spring.boot.springbootcrudapp.model.Employee;
import com.ukolov.spring.boot.springbootcrudapp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public String findAll(Model model){

        List<Employee> employeeList = employeeService.findAll();

        model.addAttribute("employees",employeeList);

        return "employee-list";
    }

    @GetMapping("/employee-create")
    public String createEmployeeForm(Employee employee){
        return "employee-create";
    }

    @PostMapping("/employee-create")
    public String createEmployee(Employee employee){
        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

    @GetMapping("/employee-delete/{id}")
    public String deleteEmployee(@PathVariable("id") int id){

        employeeService.deleteById(id);
        return "redirect:/employees";
    }

    @GetMapping("/employee-update/{id}")
    public String updateEmployeeForm(@PathVariable("id") int id, Model model){

        Employee employee = employeeService.findById(id);
        model.addAttribute("employee",employee);

        return "employee-update";
    }

    @PostMapping("/employee-update")
    public String updateEmployee(Employee employee){

        employeeService.saveEmployee(employee);
        return "redirect:/employees";
    }

}
