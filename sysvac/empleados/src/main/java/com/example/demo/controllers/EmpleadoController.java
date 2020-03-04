package com.example.demo.controllers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Empleado;
import com.example.demo.service.EmpleadoService;

@RestController
public class EmpleadoController {

	@Autowired
	Environment env;

	// se usa la propiedad server.port del application.properties
	@Value("${server.port}")
	private int port;

	@Autowired
	private EmpleadoService empleadoService;

	@GetMapping(path = "/todos")
	public List<Empleado> getEmployees() throws Exception {

		// boolean testingHystrix = false;
		// if(testingHystrix == false) {
		// throw new Exception("No se pudo cargar la lista de Empleados");
		// }

		// try {
		// Thread.sleep(2000L);
		// } catch (InterruptedException e) {
		// throw new Exception("Hubo un timeout de 2 segundos en Empleados App");
		// }

		return empleadoService.findAll().stream().map(empleado -> {
			empleado.setPuerto(Integer.parseInt(env.getProperty("local.server.port")));
			return empleado;
		}).collect(Collectors.toList());
	}

	@GetMapping(path = "/id/{id}")
	public Empleado getEmployeeById(@PathVariable Long id) {
		Empleado empleado = empleadoService.findById(id);
		empleado.setPuerto(this.port);
		return empleado;
	}
}
