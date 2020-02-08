package com.example.demo.rest;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.models.Empleado;

@FeignClient(name = "servicio-empleados")
public interface EmpleadosRestClient {

	@GetMapping(path = "/get")
	public List<Empleado> getEmployee();

	@GetMapping(path = "/get/{id}")
	public Empleado getEmployeeById(@PathVariable Long id);

}
