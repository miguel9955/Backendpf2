package com.example.proyectoturnoslogin.modelo;

import java.util.List; 

//import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
//import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="asesores")
public class Asesores {
	@Id
	
	private Long id;
	private String nombre;
	private String apellido;
	private Integer documento;
	private String contraseña;
	 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public Integer getDocumento() {
		return documento;
	}
	public void setDocumento(Integer documento) {
		this.documento = documento;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	public Asesores(Long id, String nombre, String apellido, Integer documento, String contraseña) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.contraseña = contraseña;
	}
	public Asesores() {
		super();
	}
	
//	@OneToMany(mappedBy = "asesores", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<Reporte> reportes;
//
//	public List<Reporte> getReportes() {
//		return reportes;
//	}
//	public void setReportes(List<Reporte> reportes) {
//		this.reportes = reportes;
//	}
	public Asesores(Long id, String nombre, String apellido, Integer documento, String contraseña,
			List<Reporte> reportes) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.documento = documento;
		this.contraseña = contraseña;
//		this.reportes = reportes;
	}
	
	
	
}
