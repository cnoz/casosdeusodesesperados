package com.desi.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import com.desi.entity.Contrato;
import com.desi.entity.EstadoContrato;
import com.desi.repository.ContratoRepository;

@Service
public class ContratoServiceImpl implements ContratoService{

	// Dependencia del repositorio (Base de datos)
    private final ContratoRepository contratoRepository;

    // Inyección por constructor
    public ContratoServiceImpl(ContratoRepository contratoRepository) {
        this.contratoRepository = contratoRepository;
    }

    @Override
    public List<Contrato> listarConFiltros(String propiedad, String inquilino, EstadoContrato estado, LocalDate fechaInicio) {
        // Si los textos vienen vacíos desde el HTML, los pasamos a null
        String propFiltro = (propiedad != null && !propiedad.isBlank()) ? propiedad : null;
        String inqFiltro = (inquilino != null && !inquilino.isBlank()) ? inquilino : null;

        return contratoRepository.filtrarContratos(propFiltro, inqFiltro, estado, fechaInicio);
    }
    
    /*
    @Override
    public List<Contrato> listarTodos() {
        // .findAll() viene heredado de JpaRepository
        return contratoRepository.findAll();
    }
     */
    
    @Override
    public void guardar(Contrato contrato) {
        // .save() sirve tanto para insertar uno nuevo como para actualizar
        contratoRepository.save(contrato);
    }

    @Override
    public Contrato buscarPorId(Long id) {
        // .findById() devuelve un Optional. Si no lo encuentra, lanzamos una excepción 
        // o puedes retornar null: .orElse(null);
        return contratoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Contrato no encontrado con el ID: " + id));
    }

    @Override
    public void eliminar(Long id) {
        // .deleteById() elimina el registro de la base de datos
        contratoRepository.deleteById(id);
    }
	
}
