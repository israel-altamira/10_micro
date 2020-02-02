package com.example.demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping(path = "/get")
	public List<Empleado> getEmployee() {
		return empleadoService.findAll();
	}
	
	@GetMapping("/get/{id}")
	public Empleado getEmployeeById(@PathVariable Long id) {
		return empleadoService.findById(id);
	}
}
