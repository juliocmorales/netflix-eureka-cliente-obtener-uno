package com.neoris.microservicios.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.neoris.microservicios.dao.ILibroDAO;
import com.neoris.microservicios.entity.Libro;

@Service
public class LibroService implements ILibroService {
	@Autowired
	private ILibroDAO libroDAO;
	@Override
	public Libro getLibroById(int libroId) {
		Libro obj = libroDAO.getLibroById(libroId);
		return obj;
	}	
	@Override
	public List<Libro> getAllLibros(){
		return libroDAO.getAllLibros();
	}
	@Override
	public synchronized boolean addLibro(Libro libro){
            if (libroDAO.libroExists(libro.getLibrotitulo(), libro.getLibrocategoria())) {
    	        return false;
             } else {
    	        libroDAO.addLibro(libro);
    	        return true;
             }
	}
	@Override
	public void updateLibro(Libro libro) {
		libroDAO.updateLibro(libro);
	}
	@Override
	public void deleteLibro(int libroId) {
		libroDAO.deleteLibro(libroId);
	}
} 