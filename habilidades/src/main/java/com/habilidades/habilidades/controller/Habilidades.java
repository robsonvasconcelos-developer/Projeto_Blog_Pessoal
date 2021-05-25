package com.habilidades.habilidades.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/habilidades")
public class Habilidades {
	
	@GetMapping
	public String hello() {
		return " Nesta semana, quero continuar aprendendo Spring, e entender melhor o Postman e aperfeiçoar novamente na IDE Eclipse e voltar a praticar. Com o objetivo de adquirir esses conhecimento, para continuar desenvolvendo no Projeto Integrador!!  ";
	}

}
