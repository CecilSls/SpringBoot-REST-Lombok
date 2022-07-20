package com.cgs.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.cgs.service.EmpleadoService;
import com.cgs.exception.ResourceNotFoundException;
import com.cgs.models.Empleado;
import com.cgs.repository.EmpleadoRepository;

@Service
public class EmpleadoServiceImpl implements EmpleadoService{
	
	private EmpleadoRepository repositorio;
	
	public EmpleadoServiceImpl(EmpleadoRepository repositorio) {
		super();
		this.repositorio = repositorio;
	}
	
	@Override
	public Empleado saveEmpleado(Empleado empleado) {
		return repositorio.save(empleado);
	}

	@Override
	public List<Empleado> getAllEmpleados() {
		return repositorio.findAll();
	}

	@Override
	public Empleado getEmpleadoById(long id) {
		Optional<Empleado> empleado = repositorio.findById(id);
		if(empleado.isPresent()) {
			return empleado.get();
		}else {
			throw new ResourceNotFoundException("Empleado", "Id", id);
		}
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado, long id) {
		Optional<Empleado> empleadoEnBD = repositorio.findById(id);
		if(empleadoEnBD.isPresent()) {
			Empleado saveEmpleado = empleadoEnBD.get();
			saveEmpleado.setEmail(empleado.getEmail());
			saveEmpleado.setFirstName(empleado.getFirstName());
			saveEmpleado.setLastName(empleado.getLastName());
			
			repositorio.save(saveEmpleado);
			return saveEmpleado;
		}else {
			throw new ResourceNotFoundException("Empleado", "Id", id);			
		}
	}

	@Override
	public void deleteEmpleado(long id) {
		Optional<Empleado> empleadoEnBD = repositorio.findById(id);
		if(empleadoEnBD.isPresent()) {
			repositorio.deleteById(id);			
		}else {
			throw new ResourceNotFoundException("Empleado", "Id", id);			
		}
		
	}
	

}
