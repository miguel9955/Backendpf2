package com.example.proyectoturnoslogin.controlador;

import java.util.List; 
import java.util.Map;
import java.util.HashMap;


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
import com.example.proyectoturnoslogin.modelo.Turno;
import com.example.proyectoturnoslogin.repositorio.TurnoRepositorio;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class TurnoControlador {
	@Autowired
	private TurnoRepositorio turnorepositorio;
//Metodo para listar turnos
	@GetMapping("/turno")
	public List<Turno> listarallTurnos() {
		return turnorepositorio.findAll();
	}

//Metodo para guardar turno 
	@PostMapping("/turno")
	public Turno guardarTurnos(@RequestBody Turno turno) {
		return turnorepositorio.save(turno);
	}
	

	//Buscar Turno ID
	
	@GetMapping("/turno/{id}")
	public ResponseEntity<Turno> obtenerTurnoporId(@PathVariable Integer id){
			Turno turno = turnorepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
			return ResponseEntity.ok(turno);
		
	}
	
	@PutMapping("/turno/{id}")
	public ResponseEntity<Turno> ActualizarTurno(@PathVariable Integer id, @RequestBody Turno turnodetalle){
		Turno turno = turnorepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
		
		turno.setNombre(turnodetalle.getNombre());
		turno.setApellido(turnodetalle.getApellido());
		turno.setDocumeto(turnodetalle.getDocumeto());
		turno.setEstado(turnodetalle.getEstado());
		turno.setModulo(turnodetalle.getModulo());
		turno.setTipoturno(turnodetalle.getTipoturno());
		
		Turno turnoActualizado = turnorepositorio.save(turno);

		
		return ResponseEntity.ok(turnoActualizado);	
	}
	
	@DeleteMapping("/turno/{id}")
	public ResponseEntity<Map<String,Boolean>> eliminarTurno(@PathVariable Integer id){
		Turno turno = turnorepositorio.findById(id)
				            .orElseThrow(() -> new ResourceNotFoundException("No existe el Turno con el ID : " + id));
		
		turnorepositorio.delete(turno);
		Map<String, Boolean> respuesta = new HashMap<>();
		respuesta.put("eliminar",Boolean.TRUE);
		return ResponseEntity.ok(respuesta);
    }
	
	@PutMapping("/turno/{id}/estado")
    public ResponseEntity<Turno> actualizarEstadoTurno(@PathVariable Integer id, @RequestBody Map<String, String> estado) {
        Turno turno = turnorepositorio.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("No se encontró el turno con el ID: " + id));
        
        String nuevoEstado = estado.get("estado");
        if (nuevoEstado == null || (!nuevoEstado.equals("activo") && !nuevoEstado.equals("en espera"))) {
            throw new IllegalArgumentException("El estado proporcionado no es válido.");
        }

        turno.setEstado(nuevoEstado);
        final Turno turnoActualizado = turnorepositorio.save(turno);
        return ResponseEntity.ok(turnoActualizado);
    }
}
