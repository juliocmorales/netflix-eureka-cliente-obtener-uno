package com.neoris.microservicios.dao;

import com.neoris.microservicios.entity.Usuario;

public interface IUsuarioDAO {
	Usuario getUsuarioActivo(String nombre);

}
