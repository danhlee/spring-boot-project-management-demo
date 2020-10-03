package com.sa.pma.controllers;

import com.sa.pma.dao.EmployeeRepository;
import com.sa.pma.entities.Employee;
import com.sa.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("")
    public String displayEmployees(Model model) {
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("employees", employees);
        return "employees/list-employees";
    }


    @GetMapping("/new")
    public String displayEmployeeForm(Model model) {
        Employee anEmployee = new Employee();
        model.addAttribute("employee", anEmployee);

        return "employees/new-employee";
    }

    @PostMapping("/save")
    public String createEmployee(Model model, Employee employee) {
        // save employee to DB using CRUD repo
        employeeRepo.save(employee);

        return "redirect:/employees/new";
    }
}
