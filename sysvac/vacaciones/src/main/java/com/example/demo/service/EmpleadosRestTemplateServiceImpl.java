package com.example.demo.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.dao.VacacionesDAO;
import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;

@Service(value = "EmpleadoRestTemplateService")
public class EmpleadosRestTemplateServiceImpl implements EmpleadosService {

	@Autowired
	private VacacionesDAO vacacionesDAO;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public List<Empleado> getVacaciones() {
		
		// Si usas el @LoadBalanced en el AppConfig, 
		// hay que cambiar el 
		// http://localhost:8001/get   por el nombre del microservicio:
		// http://servicio-empleados/get
		List<Empleado> empleados = Arrays
				.asList(restTemplate.getForObject("http://servicio-empleados/get", Empleado[].class));

		empleados.stream().filter(empleado -> empleado.getId() != null && empleado.getId() > 0).forEach(empleado -> {
			System.out.println(String.format("Vacaciones - buscar empleado [%d]", empleado.getId()));
			Vacaciones vacaciones = this.vacacionesDAO.findById(empleado.getId()).orElse(new Vacaciones());
			empleado.setDisfrutadoInicio(vacaciones.getDisfrutadoInicio());
			empleado.setDisfrutadoFinal(vacaciones.getDisfrutadoFinal());
			empleado.setDisfrutados(vacaciones.getDisfrutados());
			empleado.setRestantes(empleado.getGenerados() - vacaciones.getDisfrutados());
		});

		return empleados;
	}

	@Override
	public Vacaciones getVacacionesById(Long id) {
		System.out.println(String.format("Vacaciones - buscar 1 empleado [%d]", id));
		return this.vacacionesDAO.findById(id).orElse(new Vacaciones());
	}

}
