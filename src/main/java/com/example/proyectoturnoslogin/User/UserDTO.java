package com.example.proyectoturnoslogin.User;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
	int id;
    String username;
    String firstname;
    String lastname;
    String country;

}
