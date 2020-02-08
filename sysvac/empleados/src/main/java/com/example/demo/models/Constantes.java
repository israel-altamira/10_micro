package com.example.demo.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "constantes")
public class Constantes implements Serializable {

	private static final long serialVersionUID = 1332606910858492424L;

	@Id
	@Column(name = "nombre")
	public String nombre;

	@Column(name = "valor")
	public double valor;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

}
