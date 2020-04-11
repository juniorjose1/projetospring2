package br.com.alexandre.exerciciossb.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.exerciciossb.model.domain.Produto;
import br.com.alexandre.exerciciossb.model.repositories.ProdutoRepository;
import br.com.alexandre.exerciciossb.model.services.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {
	
	@Autowired
	ProdutoService service;
	
	@Autowired
	ProdutoRepository repository;

	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id) {
		Produto produtoEncontrado = service.listarProdutoPorId(id);
		return ResponseEntity.ok().body(produtoEncontrado);
	}
	
	@PostMapping("/adiciona")
	@ResponseStatus(value = HttpStatus.CREATED)
	public void adicionarProduto(@RequestParam String nome, @RequestParam Double preco){
		Produto produtoCriado = new Produto(nome, preco);
		service.salvarProduto(produtoCriado);
	}
	
	@GetMapping
	public ResponseEntity<List<Produto>> findAll(){
		List<Produto> listaDeProdutos = new ArrayList<>();
		listaDeProdutos = service.listarTudo();
		return ResponseEntity.ok().body(listaDeProdutos);
	}
	

}
