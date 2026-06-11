package com.desi.repository;

import com.desi.entity.HistorialEstadoContrato;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialEstadoRepository extends JpaRepository<HistorialEstadoContrato, Long> {
   
}