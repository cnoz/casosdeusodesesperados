package com.desi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.desi.entity.EstadoDisponibilidad;
import com.desi.entity.EstadoPublicacion;
import com.desi.entity.Propiedad;
import com.desi.entity.Publicacion;

import java.util.List;

@Repository 
public interface PublicacionesRepository extends JpaRepository<Publicacion, Long> {
    
    
    boolean existsByPropiedadIdAndEstado(Long propiedadId, EstadoPublicacion estado);

    
   
    boolean existsByPropiedadIdAndEstadoAndIdNot(Long propiedadId, EstadoPublicacion estado, Long id);

   
    @Query("SELECT p FROM Propiedad p WHERE p.eliminada = false AND p.estadoDisponibilidad = :estado")
    List<Propiedad> buscarPropiedadesDisponibles(@Param("estado") EstadoDisponibilidad estado);

    
    @Query("SELECT p FROM Propiedad p WHERE p.id = :id")
    Propiedad buscarPropiedadPorId(@Param("id") Long id);

    List<Publicacion> findByEliminadaFalse();
}