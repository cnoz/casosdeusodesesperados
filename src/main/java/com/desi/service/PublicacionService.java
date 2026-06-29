package com.desi.service;

import com.desi.entity.Publicacion;

public interface PublicacionService {

    Publicacion crearPublicacion(Publicacion publicacion);

    void eliminarPublicacion(Long id);

    void modificarPublicacion(Long id, Publicacion datosNuevos);

}