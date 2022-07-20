package com.cgs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.stereotype.Repository;

import com.cgs.models.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long>{

}
