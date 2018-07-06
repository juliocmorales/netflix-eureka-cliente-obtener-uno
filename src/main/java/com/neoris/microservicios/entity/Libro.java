package com.neoris.microservicios.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="libro")
public class Libro implements Serializable { 
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="libroid")
        private int libroid;  
	@Column(name="librotitulo")
        private String librotitulo;
	@Column(name="librocategoria")	
	private String librocategoria;
	
	public int getLibroid() {
		return libroid;
	}
	public void setLibroid(int libroid) {
		this.libroid = libroid;
	}
	public String getLibrotitulo() {
		return librotitulo;
	}
	public void setLibrotitulo(String librotitulo) {
		this.librotitulo = librotitulo;
	}
	public String getLibrocategoria() {
		return librocategoria;
	}
	public void setLibrocategoria(String librocategoria) {
		this.librocategoria = librocategoria;
	}
	
	
	
	
	
	
} 