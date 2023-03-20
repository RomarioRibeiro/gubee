package com.gubee.erp.repository;

import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.gubee.erp.model.Produto;

public class ProdutoRepository {

	@Inject
	private EntityManager manager;


	public ProdutoRepository() {

	}

	public ProdutoRepository(EntityManager manager) {
		this.manager = manager;
	}

	public Produto porId(Long id) {
		return manager.find(Produto.class, id);
	}

	public List<Produto> pesquisar(String nome) {
		String jpql = "from Produto where nome like :nome";
		
		TypedQuery<Produto> query = manager
				.createQuery(jpql, Produto.class);
		
		query.setParameter("nome", nome + "%");
		
		return query.getResultList();
	}
	
	public List<Produto> todas() {
         return manager.createQuery("from Produto", Produto.class).getResultList();
    }

	public Produto guardar(Produto Produto) {
		return manager.merge(Produto);
	}

	public void remover(Produto Produto) {
		Produto = porId(Produto.getId());
		manager.remove(Produto);
	}
	
	
	
}
