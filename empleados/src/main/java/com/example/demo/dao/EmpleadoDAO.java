package com.example.demo.dao;

import org.springframework.data.repository.CrudRepository;

import com.example.demo.models.Empleado;

public interface EmpleadoDAO extends CrudRepository<Empleado, Long>{

}
