package com.desi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.desi.entity.Ciudad;
import com.desi.repository.CiudadRepository;

public interface CiudadService {

	// MEOTOD LISTAR CIUDAD
	List<Ciudad> listarTodas();

	// METODO BUSCAR CIUDAD
	Ciudad buscarPorId(Long id);

	// METODO GUARDAR CIUDAD
	Ciudad guardar(Ciudad ciudad);

	// METODO ELIMIANR CIUDAD
	void eliminar(Long id);
}
