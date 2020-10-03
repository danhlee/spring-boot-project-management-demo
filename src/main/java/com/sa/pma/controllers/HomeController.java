package com.sa.pma.controllers;

import com.sa.pma.dao.EmployeeRepository;
import com.sa.pma.dao.ProjectRepository;
import com.sa.pma.entities.Employee;
import com.sa.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ProjectRepository projRepo;

    @Autowired
    EmployeeRepository employeeRepo;

    @GetMapping("/")
    public String displayHome(Model model) {
        List<Project> projects = projRepo.findAll();
        List<Employee> employees = employeeRepo.findAll();
        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);
        return "main/home";
    }
}
