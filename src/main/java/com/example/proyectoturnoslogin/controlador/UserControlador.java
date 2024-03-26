package com.example.proyectoturnoslogin.controlador;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.proyectoturnoslogin.User.UserService;
import com.example.proyectoturnoslogin.User.UserDTO;
import com.example.proyectoturnoslogin.User.UserRequest;
import com.example.proyectoturnoslogin.User.UserResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping(value = "/api/v1/user")
@RequiredArgsConstructor
@CrossOrigin(origins = { "http://localhost:4200" })
public class UserControlador {
	private final UserService userService;

	@GetMapping(value = "{id}")
	public ResponseEntity<UserDTO> getUser(@PathVariable Integer id) {
		UserDTO userDTO = userService.getUser(id);
		if (userDTO == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(userDTO);
	}

	@PutMapping()
	public ResponseEntity<UserResponse> updateUser(@RequestBody UserRequest userRequest) {
		return ResponseEntity.ok(userService.updateUser(userRequest));
	}
}
