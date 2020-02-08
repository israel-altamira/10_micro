package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;
import com.example.demo.service.EmpleadosService;

@RestController
public class VacacionesController {

	@Autowired
	@Qualifier(value = "EmpleadoRestService")
	EmpleadosService empleadosService;

	@GetMapping(path = "/get")
	public List<Empleado> getVacaciones() {
		return this.empleadosService.getVacaciones();
	}

	@GetMapping(path = "/get/{id}")
	public Vacaciones getVacacionesById(@PathVariable Long id) {
		return this.empleadosService.getVacacionesById(id);
	}
}
