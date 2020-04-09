package br.com.alexandre.exerciciossb.model.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexandre.exerciciossb.model.domain.Produto;
import br.com.alexandre.exerciciossb.model.repositories.ProdutoRepository;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repo;
	
	public Produto listarProdutoPorId(Integer id) {
		Optional<Produto> produtoEncontrado = repo.findById(id);
		return produtoEncontrado.orElse(null);
	}

}
