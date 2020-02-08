package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private Long empleadoId;
	private String nombre;
	private Date ingreso;
	private double sueldo;
	private int generados;
	private double antiguedad;
	private Date vigenciaInicio;
	private Date vigenciaFinal;
	private Date disfrutadoInicio;
	private Date disfrutadoFinal;
	private int disfrutados;
	private int restantes;
	private int puerto;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double sueldo) {
		this.sueldo = sueldo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public int getGenerados() {
		return generados;
	}

	public void setGenerados(int generados) {
		this.generados = generados;
	}

	public double getAntiguedad() {
		return antiguedad;
	}

	public void setAntiguedad(double antiguedad) {
		this.antiguedad = antiguedad;
	}

	public Date getVigenciaInicio() {
		return vigenciaInicio;
	}

	public void setVigenciaInicio(Date vigenciaInicio) {
		this.vigenciaInicio = vigenciaInicio;
	}

	public Date getVigenciaFinal() {
		return vigenciaFinal;
	}

	public void setVigenciaFinal(Date vigenciaFinal) {
		this.vigenciaFinal = vigenciaFinal;
	}

	public Date getDisfrutadoInicio() {
		return disfrutadoInicio;
	}

	public void setDisfrutadoInicio(Date disfrutadoInicio) {
		this.disfrutadoInicio = disfrutadoInicio;
	}

	public Date getDisfrutadoFinal() {
		return disfrutadoFinal;
	}

	public void setDisfrutadoFinal(Date disfrutadoFinal) {
		this.disfrutadoFinal = disfrutadoFinal;
	}

	public int getDisfrutados() {
		return disfrutados;
	}

	public void setDisfrutados(int disfrutados) {
		this.disfrutados = disfrutados;
	}

	public int getRestantes() {
		return restantes;
	}

	public void setRestantes(int restantes) {
		this.restantes = restantes;
	}

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

}
