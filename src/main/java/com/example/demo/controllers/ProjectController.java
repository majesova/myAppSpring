package com.example.demo.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.entities.Project;
import com.example.demo.entities.Task;

@Controller
public class ProjectController {

	
	@GetMapping("/projects/")
	public ModelAndView Index() {
		ModelAndView mv = new ModelAndView("projects_list");
		List<Project> projects = new ArrayList<Project>();
		Project project = new Project();
		//TODO: Hardcoded
		project.setKey("P001");
		project.setName("Proyecto DEMO 1");
		projects.add(project);
		mv.addObject("projects", projects);
		return mv;
	}
	
	@GetMapping("/projects/create")
    public String PrepareCreate(Project project) {
        return "projects_create";
    }
	
	@PostMapping("/projects/create")
	public String PostProject(@Valid Project project, BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			return "projects_create";
		}
		//Do save
		return "redirect:/projects/";
	}
	
	@GetMapping("/project/tasks/{project_key}")
	public ModelAndView ProjectTasks(@PathVariable String project_key) {
		ModelAndView mv = new ModelAndView("tasks_list");
		//query project
		//TODO: Hardcoded
		mv.addObject("project_key","P001");
		List<Task> tasks = new ArrayList<Task>();
		Task task = new Task();
		//TODO: Hardcoded
		task.setName("Task DEMO 1");
		task.setId(100);
		task.setIsCompleted(true);
		tasks.add(task);

		mv.addObject("tasks", tasks);
		return mv;
	}
	
	
}
