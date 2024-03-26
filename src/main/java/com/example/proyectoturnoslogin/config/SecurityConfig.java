package com.example.proyectoturnoslogin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.FormLoginConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.example.proyectoturnoslogin.jwt.JwtAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
	
	private final JwtAuthenticationFilter jwtAuthenticationFilter;
	private final AuthenticationProvider authenticationProvider;
	
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 return http
				 .cors().and() // Habilitar CORS
				 .csrf(csrf->
				 csrf
				 .disable()).authorizeHttpRequests(authRequest->
				 authRequest
				 .requestMatchers("/auth/**","/api/v1/turno/**").permitAll().
				 anyRequest().authenticated()
				 ).sessionManagement(sessionManager->
				 sessionManager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				 .authenticationProvider(authenticationProvider)
				 .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
				 .build();
		            
		
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    configuration.addAllowedOrigin("http://localhost:4200"); // Permitir solicitudes desde este origen
	    configuration.addAllowedMethod("*"); // Permitir todos los métodos HTTP
	    configuration.addAllowedHeader("*"); // Permitir todos los encabezados
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

}
