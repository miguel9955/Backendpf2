package com.example.proyectoturnoslogin.controlador;

import java.util.HashMap;  
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.proyectoturnoslogin.exceptions.ResourceNotFoundException;
import com.example.proyectoturnoslogin.modelo.Reporte;
import com.example.proyectoturnoslogin.repositorio.ReporteRepositorio;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class ReporteControlador {
	@Autowired
	private ReporteRepositorio reporterepositorio;
//Metodo para listar turnos
	@GetMapping("/reporte")
	public List<Reporte> listarallReportes() {
		return reporterepositorio.findAll();
	}

//Metodo para guardar turno 
	@PostMapping("/reporte")
	public Reporte guardarReporte(@RequestBody Reporte reporte) {
		return reporterepositorio.save(reporte);
		
	}
	

	//Buscar Turno ID
	
	@GetMapping("/reporte/{id}")
	public ResponseEntity<Reporte> obtenerTurnoporId(@PathVariable Long id){
		Reporte reporte = reporterepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
			return ResponseEntity.ok(reporte);
		
	}
	
	@PutMapping("/reporte/{id}")
	public ResponseEntity<Reporte> ActualizarTurno(@PathVariable Long id, @RequestBody Reporte reportedetalle){
		Reporte reporte = reporterepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
		
		reporte.setId_reporte(reportedetalle.getId_reporte());
		reporte.setContenido(reportedetalle.getContenido());
		reporte.setAsesor(reportedetalle.getAsesor());
		reporte.setTurno(reportedetalle.getTurno());
		
		Reporte reporteActualizado = reporterepositorio.save(reporte);

		
		return ResponseEntity.ok(reporteActualizado);	
	}
	
	@DeleteMapping("/reporte/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarTurno(@PathVariable Long id){
		Reporte reporte = reporterepositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el Turno con el ID : " + id));
		
		reporterepositorio.delete(reporte);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }

}
