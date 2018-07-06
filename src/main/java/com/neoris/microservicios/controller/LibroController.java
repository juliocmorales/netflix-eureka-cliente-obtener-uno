package com.neoris.microservicios.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;


import com.neoris.microservicios.entity.Libro;
import com.neoris.microservicios.service.ILibroService;


@Controller
//@CrossOrigin(origins="http://localhost:4200", allowedHeaders="*")
@RequestMapping("api")
public class LibroController {
	@Autowired
	private ILibroService libroService;
	
	@GetMapping("libro/{id}")
	public ResponseEntity<Libro> getLibroById(@PathVariable("id") Integer id) {
		Libro libro = libroService.getLibroById(id);
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}
	/*
	@GetMapping("libros")
	public ResponseEntity<List<Libro>> getAllLibros() {
		   Logger log = LoggerFactory.getLogger(LibroController.class);	
		List<Libro> list = libroService.getAllLibros();
		 log.info("log informacion");
		 log.error("error susedio en la app");
		 log.warn("esto es una advertencia");
		 
		return new ResponseEntity<List<Libro>>(list, HttpStatus.OK);
	}
	@PostMapping("libro")
	public ResponseEntity<Void> addLibro(@RequestBody Libro libro, UriComponentsBuilder builder) {
                boolean flag = libroService.addLibro(libro);
                if (flag == false) {
        	    return new ResponseEntity<Void>(HttpStatus.CONFLICT);
                }
                HttpHeaders headers = new HttpHeaders();
                headers.setLocation(builder.path("/libro/{id}").buildAndExpand(libro.getLibroid()).toUri());
                return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}
	@PutMapping("libro")
	public ResponseEntity<Libro> updateLibro(@RequestBody Libro libro) {
		libroService.updateLibro(libro);
		return new ResponseEntity<Libro>(libro, HttpStatus.OK);
	}
	@DeleteMapping("libro/{id}")
	public ResponseEntity<Void> deleteLibro(@PathVariable("id") Integer id) {
		libroService.deleteLibro(id);
		return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
	}	
	*/
}  