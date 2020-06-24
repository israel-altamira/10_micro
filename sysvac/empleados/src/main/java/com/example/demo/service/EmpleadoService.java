package com.example.demo.service;

import java.util.List;

import com.example.demo.models.Empleado;

public interface EmpleadoService {

	public List<Empleado> findAll();
	public Empleado findById(Long id);
	public Empleado create(Empleado empleado);
	public Empleado update(Empleado empleado);
	public void delete(Long Id);
}
