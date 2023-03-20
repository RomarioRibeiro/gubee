package com.gubee.erp.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.gubee.erp.model.Produto;

public class ProdutoRepository {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("gubeePu") ;
		
		EntityManager em = emf.createEntityManager();
		
		List<Produto> listar = em.createQuery("from Produto", Produto.class).getResultList();
		
		System.out.println(listar);
		
		em.close();
		emf.close();
		
		
	}
	
}
