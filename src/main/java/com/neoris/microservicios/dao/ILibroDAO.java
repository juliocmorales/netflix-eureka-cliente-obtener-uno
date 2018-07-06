package com.neoris.microservicios.dao;

import java.util.List;
import com.neoris.microservicios.entity.Libro;

public interface ILibroDAO {
	List<Libro> getAllLibros();
    Libro getLibroById(int libroId);
    void addLibro(Libro libro);
    void updateLibro(Libro libro);
    void deleteLibro(int libroId);
    boolean libroExists(String titulo, String categoria);

}
