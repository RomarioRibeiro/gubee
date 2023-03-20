package com.gubee.erp.service;

import java.io.Serializable;

import javax.inject.Inject;

import com.gubee.erp.model.Produto;
import com.gubee.erp.repository.ProdutoRepository;
import com.gubee.erp.util.Transacional;

public class CadastroProdutoService implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ProdutoRepository  produtoRepository;
	
	@Transacional
	public void salvar (Produto produto) {
		produtoRepository.guardar(produto);
	}
	@Transacional
	public void excluir(Produto produto) {
		produtoRepository.remover(produto);
	}
}
