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
import com.example.proyectoturnoslogin.modelo.Asesores;
import com.example.proyectoturnoslogin.repositorio.AsesoresRepositorio;


@RestController
@RequestMapping("/api/v1/")
@CrossOrigin(origins = "http://localhost:4200")
public class AsesoresControlador {
	@Autowired
	private AsesoresRepositorio asesoresrepositorio;
	//Metodo para listar turnos
		@GetMapping("/asesores")
		public List<Asesores> listarallAsesores() {
			return asesoresrepositorio.findAll();
		}

	//Metodo para guardar turno 
		@PostMapping("/asesores")
		public Asesores guardarasesores(@RequestBody Asesores asesores) {
			return asesoresrepositorio.save(asesores);
		}
		

		//Buscar Turno ID
		
		@GetMapping("/asesores/{id}")
		public ResponseEntity<Asesores> obtenerAsesoresporId(@PathVariable Long id){
			Asesores asesores = asesoresrepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
				return ResponseEntity.ok(asesores);
			
		}
		
		@PutMapping("/asesores/{id}")
		public ResponseEntity<Asesores> ActualizarTurno(@PathVariable Long id, @RequestBody Asesores asesoresdetalle){
			Asesores asesores = asesoresrepositorio.findById(id).orElseThrow(()-> new ResourceNotFoundException("No existe el turno con el ID"+ id));
			
			asesores.setNombre(asesoresdetalle.getNombre());
			asesores.setApellido(asesoresdetalle.getApellido());
			asesores.setDocumento(asesoresdetalle.getDocumento());
			asesores.setContraseña(asesoresdetalle.getContraseña());
			asesores.setId(asesoresdetalle.getDocumento().longValue());
			Asesores asesoresActualizado = asesoresrepositorio.save(asesores);

			
			return ResponseEntity.ok(asesoresActualizado);	
		}
		
		@DeleteMapping("/asesores/{id}")
		public ResponseEntity<Map<String,Boolean>> eliminarAsesores(@PathVariable Long id){
			Asesores asesores = asesoresrepositorio.findById(id)
					            .orElseThrow(() -> new ResourceNotFoundException("No existe el Turno con el ID : " + id));
			
			asesoresrepositorio.delete(asesores);
			Map<String, Boolean> respuesta = new HashMap<>();
			respuesta.put("eliminar",Boolean.TRUE);
			return ResponseEntity.ok(respuesta);
	    }

}
