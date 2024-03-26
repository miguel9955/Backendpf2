package com.example.proyectoturnoslogin.modelo;

import jakarta.persistence.*;

@Entity
@Table(name="reporte")
public class Reporte {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_reporte;
	private String contenido;
	
	
	public Long getId_reporte() {
		return id_reporte;
	}


	public void setId_reporte(Long id_reporte) {
		this.id_reporte = id_reporte;
	}


	public String getContenido() {
		return contenido;
	}


	public void setContenido(String contenido) {
		this.contenido = contenido;
	}


	@ManyToOne
    @JoinColumn(name = "asesor_id")
    private Asesores asesor;
	@ManyToOne
    @JoinColumn(name = "turno_id")
    private Turno turno;


	public Asesores getAsesor() {
		return asesor;
	}


	public void setAsesor(Asesores asesor) {
		this.asesor = asesor;
	}


	public Turno getTurno() {
		return turno;
	}


	public void setTurno(Turno turno) {
		this.turno = turno;
	}
	

}
