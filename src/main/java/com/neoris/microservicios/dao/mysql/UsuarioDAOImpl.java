package com.neoris.microservicios.dao.mysql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.neoris.microservicios.dao.IUsuarioDAO;
import com.neoris.microservicios.entity.Usuario;

@Repository
@Transactional
public class UsuarioDAOImpl implements IUsuarioDAO {
	@PersistenceContext	
	private EntityManager entityManager;
	public Usuario getUsuarioActivo(String nombre) {
		Usuario usuarioInfo = new Usuario();
		short activo = 1;
		List<?> list =entityManager.createQuery("SELECT u FROM Usuario u WHERE userName like :usu and activo=:acti")
				.setParameter("usu", nombre) .setParameter("acti", activo).getResultList();
		if(!list.isEmpty()) {
			usuarioInfo = (Usuario)list.get(0);
		}
		return usuarioInfo;
	}
} 