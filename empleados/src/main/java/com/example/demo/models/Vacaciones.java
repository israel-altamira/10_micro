package com.example.demo.models;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "vacaciones")
public class Vacaciones implements Serializable {

	private static final long serialVersionUID = -2282146605321134429L;

	@Id
	@Column(name = "empleado_id")
	public Long empleadoId;

	@Column(name = "disfrutado_inicio")
	@Temporal(TemporalType.DATE)
	public Date disfrutadoInicio;

	@Column(name = "disfrutado_final")
	@Temporal(TemporalType.DATE)
	public Date disfrutadoFinal;

	@Column(name = "disfrutados")
	public int disfrutados;

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
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

}
