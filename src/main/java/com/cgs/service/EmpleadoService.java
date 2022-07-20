package com.cgs.service;

import java.util.List;

import com.cgs.models.Empleado;

public interface EmpleadoService {

	Empleado saveEmpleado(Empleado empleado);
	List<Empleado> getAllEmpleados();
	Empleado getEmpleadoById(long id);
	Empleado updateEmpleado(Empleado empleado, long id);
	void deleteEmpleado(long id);
	
}
