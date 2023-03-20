package com.gubee.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.gubee.erp.model.Mercado;

public class MercadoRepository implements Serializable {


	private static final long serialVersionUID = 1L;

	@Inject
	private EntityManager manager;

	public MercadoRepository() {

	}

	public MercadoRepository(EntityManager manager) {
		this.manager = manager;
	}
	
	public List<Mercado> pesquisar(String nome) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		
		CriteriaQuery<Mercado> criteriaQuery = criteriaBuilder.createQuery(Mercado.class);		
		Root<Mercado> root = criteriaQuery.from(Mercado.class);			
		criteriaQuery.select(root);				
		criteriaQuery.where(criteriaBuilder.like(root.get("nome"), nome + "%"));		
		
		TypedQuery<Mercado> query = manager.createQuery(criteriaQuery);
		
		return query.getResultList();
	}
}
