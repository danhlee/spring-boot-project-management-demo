package com.sa.pma.controllers;

import com.sa.pma.dao.ProjectRepository;
import com.sa.pma.entities.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/projects")
public class ProjectController {

    @Autowired
    ProjectRepository projRepo;

    @GetMapping("")
    public String displayProjects(Model model) {
        List<Project> projects = projRepo.findAll();
        model.addAttribute("projects", projects);
        return "projects/list-projects";
    }

    @GetMapping("/new")
    public String displayProjectForm(Model model) {
        Project aProject = new Project();
        model.addAttribute("project", aProject);

        return "projects/new-project";
    }

    @PostMapping("/save")
    public String createProject(Project project, Model model) {
        // this should handle saving to DB
        projRepo.save(project);

        // use redirect to prevent duplicate submissions to DB
        return "redirect:/projects/new";
    }


}
