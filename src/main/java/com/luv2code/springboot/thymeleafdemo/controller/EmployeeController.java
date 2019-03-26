package com.luv2code.springboot.thymeleafdemo.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.luv2code.springboot.thymeleafdemo.model.Employee;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

	private List<Employee> listEmployees;

	@PostConstruct
	public void loadData() {

		Employee employee1 = new Employee(1, "Med kamal", "Beerami", "kamal-ber@hotmail.fr");
		Employee employee2 = new Employee(2, "Med", "cydonia", "cydonia@hotmail.fr");
		Employee employee3 = new Employee(3, "mehdi", "toptravel", "ber@gmail.com");
		Employee employee4 = new Employee(4, "ali", "andonu", "andonu@gmail.com");
		listEmployees = new ArrayList<Employee>();
		listEmployees.add(employee1);
		listEmployees.add(employee2);
		listEmployees.add(employee3);
		listEmployees.add(employee4);

	}

	@GetMapping("/list")
	public String listEmployees(Model theModel) {

		theModel.addAttribute("employees", listEmployees);
		return "list-employees";
	}

}
