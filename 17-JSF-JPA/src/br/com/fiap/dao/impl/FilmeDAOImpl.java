package br.com.fiap.dao.impl;

import javax.persistence.EntityManager;

import br.com.fiap.dao.FilmeDAO;
import br.com.fiap.entity.Filme;

public class FilmeDAOImpl extends GenericDAOImpl<Filme, Integer> implements FilmeDAO{

	public FilmeDAOImpl(EntityManager em) {
		super(em);
	}

	@Override
	public long contarPorTitulo(String titulo) {
		return em.createQuery("select count(f) from Filme f "
				+ "where f.titulo = :D",Long.class)
				.setParameter("D", titulo)
				.getSingleResult();
	}

}
