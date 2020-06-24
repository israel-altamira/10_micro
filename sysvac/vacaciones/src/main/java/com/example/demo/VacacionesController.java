package com.example.demo;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;
import com.example.demo.service.EmpleadosService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

// esta anotacion es del cliente spring-cloud-starter-config 
@RefreshScope
@RestController
public class VacacionesController {

	@Value(value = "${vacaciones.texto}")
	private String texto;

	@Autowired
	private Environment env;

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
		// 2) despues hacer un empleado.getVacacionesById en base al empleado-id
		// anterior
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

	@GetMapping("/config")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto) {
		Map<String, String> json = new HashMap<String, String>();
		json.put("texto", this.texto);
		json.put("puerto", puerto);
		if (this.env.getActiveProfiles() != null && this.env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("configuracion.autor.nombre"));
			json.put("autor.email", env.getProperty("configuracion.autor.email"));
		}
		return new ResponseEntity<Map<String, String>>(json, HttpStatus.OK);
	}

}
