package com.desi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.desi.entity.HistorialEstadoPropiedad;

//Repositorio para manejar los registros del historial de estados
public interface HistorialEstadoPropiedadRepository extends JpaRepository<HistorialEstadoPropiedad, Long> {

}
