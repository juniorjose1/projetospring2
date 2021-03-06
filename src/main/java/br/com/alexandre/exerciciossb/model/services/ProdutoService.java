package br.com.alexandre.exerciciossb.model.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.alexandre.exerciciossb.model.domain.Produto;
import br.com.alexandre.exerciciossb.model.repositories.ProdutoRepository;
import br.com.alexandre.exerciciossb.model.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
	ProdutoRepository repository;
	
	public Produto listarProdutoPorId(Integer id) {
		Optional<Produto> produtoEncontrado = repository.findById(id);
		return produtoEncontrado.orElseThrow(() -> new ObjectNotFoundException
			("Produto Não Encontrado ! ID: " + id + ", Tipo: " + Produto.class.getName()));
	}
	
	public void salvarProduto(Produto produto) {
		repository.save(produto);
	}
	
	public List<Produto> listarTudo(){
		List<Produto> listaDeProdutos = new ArrayList<>();
		listaDeProdutos = repository.findAll();
		return listaDeProdutos;
	}

}
