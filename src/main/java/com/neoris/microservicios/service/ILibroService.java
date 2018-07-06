package com.neoris.microservicios.service;

import java.util.List;

import org.springframework.security.access.annotation.Secured;

import com.neoris.microservicios.entity.Libro;

public interface ILibroService {
	 @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     List<Libro> getAllLibros();
     @Secured ({"ROLE_ADMIN", "ROLE_USER"})
     Libro getLibroById(int libroId);
     @Secured ({"ROLE_ADMIN"})
     boolean addLibro(Libro libro);
     @Secured ({"ROLE_ADMIN"})
     void updateLibro(Libro libro);
     @Secured ({"ROLE_ADMIN"})
     void deleteLibro(int libroId);

}
