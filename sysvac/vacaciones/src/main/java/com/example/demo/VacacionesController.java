package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;
import com.example.demo.service.EmpleadosService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class VacacionesController {

	@Autowired
	@Qualifier(value = "EmpleadoRestService")
	EmpleadosService empleadosService;

	@HystrixCommand(fallbackMethod = "getVacacionesDefault")
	@GetMapping(path = "/todos")
	public List<Empleado> getVacaciones() {
		return this.empleadosService.getVacaciones();
	}
	
	@GetMapping(path = "/id/{id}")
	public Vacaciones getVacacionesByQuery(@PathVariable Long id) {
		// hay que hacer update de la logica de este metodo, 
		// por que debe ser una busqueda en base a un query
		// es decir:
		// 1) seria mandar traer el empleado por empleador.getByQuery("algo")
		// 2) despues hacer un empleado.getVacacionesById en base al empleado-id anterior
		return this.empleadosService.getVacacionesById(id);
	}
	
	public List<Empleado> getVacacionesDefault() {
		Empleado empleado = new Empleado();
		empleado.setNombre("-");
		empleado.setIngreso(new Date());
		empleado.setSueldo(0d);
		empleado.setGenerados(0);
		empleado.setAntiguedad(0d);
		empleado.setVigenciaFinal(new Date());
		empleado.setVigenciaInicio(new Date());
		empleado.setRestantes(0);
		List<Empleado> empleados = new ArrayList<Empleado>();
		empleados.add(empleado);
		return empleados;
	}
}
