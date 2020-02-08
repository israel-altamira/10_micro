package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "empleados")
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long id;

	@Column(name = "empleado_id", unique = true)
	public Long empleadoId;

	@Column(name = "nombre")
	public String nombre;

	@Column(name = "ingreso")
	@Temporal(TemporalType.DATE)
	public Date ingreso;

	@Column(name = "sueldo")
	public double sueldo;

	@Column(name = "generados")
	public int generados;

	@Column(name = "antiguedad")
	public double antiguedad;

	@Column(name = "vigencia_inicio")
	@Temporal(TemporalType.DATE)
	public Date vigenciaInicio;

	@Column(name = "vigencia_final")
	@Temporal(TemporalType.DATE)
	public Date vigenciaFinal;

	@Transient
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

	public int getPuerto() {
		return puerto;
	}

	public void setPuerto(int puerto) {
		this.puerto = puerto;
	}

}
