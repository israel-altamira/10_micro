package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.VacacionesDAO;
import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;
import com.example.demo.rest.EmpleadosRestClient;

@Service(value = "EmpleadoRestService")
public class EmpleadosRestServiceImpl implements EmpleadosService {

	@Autowired
	private VacacionesDAO vacacionesDAO;

	@Autowired
	private EmpleadosRestClient empleadosRestClient;

	@Override
	public List<Empleado> getVacaciones() {
		List<Empleado> empleados = empleadosRestClient.getEmployees();

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
