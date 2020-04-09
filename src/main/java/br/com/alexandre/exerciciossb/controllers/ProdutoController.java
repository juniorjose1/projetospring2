package br.com.alexandre.exerciciossb.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.exerciciossb.model.domain.Produto;
import br.com.alexandre.exerciciossb.model.services.ProdutoService;

@RestController
@RequestMapping(path = "/produtos")
public class ProdutoController {

	@Autowired
	ProdutoService service;
	
	@GetMapping("/{id}")
	public ResponseEntity<Produto> findById(@PathVariable Integer id){
		Produto produtoEncontrado = service.listarProdutoPorId(id);
		
		return ResponseEntity.ok().body(produtoEncontrado);
	}
	
}
