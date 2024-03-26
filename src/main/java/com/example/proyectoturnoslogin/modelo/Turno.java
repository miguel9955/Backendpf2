package com.example.proyectoturnoslogin.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="turno")
public class Turno {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String apellido;
	private Integer Documeto;
	private String estado;
	private String discapacidad;
	private String modulo;
	private String tipoturno;
	
	public String getTipoturno() {
		return tipoturno;
	}
	public void setTipoturno(String tipoturno) {
		this.tipoturno = tipoturno;
	}
	public String getModulo() {
		return modulo;
	}
	public void setModulo(String modulo) {
		this.modulo = modulo;
	}
	public String getDiscapacidad() {
		return discapacidad;
	}
	public void setDiscapacidad(String discapacidad) {
		this.discapacidad = discapacidad;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public Integer getDocumeto() {
		return Documeto;
	}
	public void setDocumeto(Integer documeto) {
		Documeto = documeto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Turno() {
		super();
	}
	public Turno(Integer id, String nombre, String apellido, Integer documeto, String estado,String discapacidad, String modulo,String tipoturno) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		Documeto = documeto;
		this.estado = estado;
		this.discapacidad = discapacidad;
		this.modulo= modulo;
		this.tipoturno= tipoturno;

	}
	
	
}
