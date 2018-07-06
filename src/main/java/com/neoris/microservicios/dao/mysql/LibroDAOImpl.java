package com.neoris.microservicios.dao.mysql;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.neoris.microservicios.dao.ILibroDAO;
import com.neoris.microservicios.entity.Libro;

@Transactional
@Repository
//@CrossOrigin(origins = "http://localhost:4200")
public class LibroDAOImpl implements ILibroDAO {
	@PersistenceContext	
	private EntityManager entityManager;	
	@Override
	public Libro getLibroById(int libroId) {
		return entityManager.find(Libro.class, libroId);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Libro> getAllLibros() {
		String hql = "FROM Libro as lib ORDER BY lib.libroid";
		return (List<Libro>) entityManager.createQuery(hql).getResultList();
	}	
	@Override
	public void addLibro(Libro libro) {
		entityManager.persist(libro);
	}
	@Override
	public void updateLibro(Libro libro) {
		Libro libr = getLibroById(libro.getLibroid());
		libr.setLibrotitulo(libro.getLibrotitulo());
		libr.setLibrocategoria(libro.getLibrocategoria());
		entityManager.flush();
	}
	@Override
	public void deleteLibro(int libroId) {
		entityManager.remove(getLibroById(libroId));
	}
	@Override
	public boolean libroExists(String titulo, String categoria) {
		String hql = "FROM Libro as lib WHERE lib.librotitulo like :titu and lib.librocategoria like :cate";
		int count = entityManager.createQuery(hql).setParameter("titu", titulo)
		              .setParameter("cate", categoria).getResultList().size();
		return count > 0 ? true : false;
	}
} 