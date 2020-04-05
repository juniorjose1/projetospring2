package br.com.alexandre.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alexandre.exerciciossb.models.Cliente;

@RestController
@RequestMapping("/clientes")
public class ClienteController {
	
	@GetMapping("/1")
	public Cliente obterCLiente() {
		return new Cliente(1, "Alexandre", "44261478828");
	}
	
}
