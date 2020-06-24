package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.EmpleadoDAO;
import com.example.demo.models.Empleado;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoDAO empleadoDAO;
	
	@Override
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		System.out.println("Empleados - buscando todos los empleados");
		return (List<Empleado>) empleadoDAO.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findById(Long id) {
		System.out.println(String.format("Empleados - buscando id [%d]", id));
		return empleadoDAO.findById(id).orElse(null);
	}

	@Override
	public Empleado create(Empleado empleado) {
		System.out.println("Empleados - crear");
		return empleadoDAO.save(empleado);
	}

	@Override
	public Empleado update(Empleado empleado) {
		System.out.println("Empleados - update");
		Optional<Empleado> found = empleadoDAO.findById(empleado.getId());
		return empleadoDAO.save(found.get());
	}

	@Override
	public void delete(Long id) {
		empleadoDAO.deleteById(id);
	}

	
}
