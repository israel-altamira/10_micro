package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sueldos")
public class Sueldos implements Serializable {

	private static final long serialVersionUID = -2006869168458168883L;

	@Id
	@Column(name = "empleado_id")
	public Long empleadoId;

	@Column(name = "diario")
	public double diario;

	@Column(name = "salario_fiscal")
	public double salarioFiscal;

	@Column(name = "total_vacaciones")
	public double totalVacaciones;

	@Column(name = "total_prima_vacacionnal")
	public double totalPrimaVacacional;

	@Column(name = "sueldo_fiscal")
	public double sueldoFiscal;

	@Column(name = "complemento")
	public double complemento;

	public Long getEmpleadoId() {
		return empleadoId;
	}

	public void setEmpleadoId(Long empleadoId) {
		this.empleadoId = empleadoId;
	}

	public double getDiario() {
		return diario;
	}

	public void setDiario(double diario) {
		this.diario = diario;
	}

	public double getSalarioFiscal() {
		return salarioFiscal;
	}

	public void setSalarioFiscal(double salarioFiscal) {
		this.salarioFiscal = salarioFiscal;
	}

	public double getTotalVacaciones() {
		return totalVacaciones;
	}

	public void setTotalVacaciones(double totalVacaciones) {
		this.totalVacaciones = totalVacaciones;
	}

	public double getTotalPrimaVacacional() {
		return totalPrimaVacacional;
	}

	public void setTotalPrimaVacacional(double totalPrimaVacacional) {
		this.totalPrimaVacacional = totalPrimaVacacional;
	}

	public double getSueldoFiscal() {
		return sueldoFiscal;
	}

	public void setSueldoFiscal(double sueldoFiscal) {
		this.sueldoFiscal = sueldoFiscal;
	}

	public double getComplemento() {
		return complemento;
	}

	public void setComplemento(double complemento) {
		this.complemento = complemento;
	}
}
