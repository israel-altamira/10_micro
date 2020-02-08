package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Empleado;
import com.example.demo.models.Vacaciones;

public interface EmpleadosService {

	public List<Empleado> getVacaciones();
	public Vacaciones getVacacionesById(Long id);

}
