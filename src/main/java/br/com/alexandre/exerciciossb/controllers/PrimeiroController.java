package br.com.alexandre.exerciciossb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeiroController {
	
	@GetMapping(path = "/saudacao")
	public String ola() {
		return "Olá Mundo !";
	}

}
