package com.cgs.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cgs.models.Empleado;
import com.cgs.service.EmpleadoService;

@RestController
@RequestMapping("/api/empleados")
public class EmpleadoController {
	
	@Autowired
	private EmpleadoService empleadoService;
	
	// Create new 'Empleado' in the DB
	@PostMapping
	public ResponseEntity<Empleado> saveEmpleado(@RequestBody Empleado empleado){
		return new ResponseEntity<Empleado>(empleadoService.saveEmpleado(empleado), HttpStatus.CREATED);
	}
	
	// Get All 'Empleados' from DB
	@GetMapping
	public List<Empleado> getAllEmpleados(){
		return empleadoService.getAllEmpleados();
	}
	
	// Get one 'Empleado' by ID
	@GetMapping("{id}")
	public ResponseEntity<Empleado> getEmpleado(@PathVariable long id){
		return new ResponseEntity<Empleado>(empleadoService.getEmpleadoById(id), HttpStatus.OK);
	}
	
	// Update a 'Empleado' by ID
	@PutMapping("{id}")
	public ResponseEntity<Empleado> updateEmpleado(@PathVariable long id,
													@RequestBody Empleado empleado){
		return new ResponseEntity<Empleado>(empleadoService.updateEmpleado(empleado, id), HttpStatus.OK);		
	}
	
	// Delete a 'Empleado' by ID
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmpleado(@PathVariable long id){
		
		empleadoService.deleteEmpleado(id);
		
		return new ResponseEntity<String>("Empleado eliminado correctamente!", HttpStatus.OK);
	}

}
