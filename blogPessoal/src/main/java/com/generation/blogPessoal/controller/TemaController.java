// Segunda Camada CONTROLLER do projeto !!

package com.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.Tema;
import com.generation.blogPessoal.repository.TemaRepository;

//Para falar que isso SRIA UM CONTROLLER Necessarios criar varios END Points!!

@RestController				//Primeiro anotacao de End Point!
@CrossOrigin(origins = "*", allowedHeaders = "*")					// Ver tudo , independente da Origem, que estamos consumindo
public class TemaController {
	
	//Para INjetar o SERVICO, usarei o @Autowired !!
	@Autowired
	private TemaRepository repository;
	
	//Criando os End Points, e o primeiro seria @GetMapping
	@GetMapping // para fazer a tarefa como se fosse GetAll!
	public ResponseEntity<List<TemaRepository>> getAll(){//(x?) chamo o GetAll () e nao receber mada como parametro, mas, ABRE Chave e Fecha chaves {}
		//sobre a linha ACIMA: <List> ao chamar a List com ATALHO do Teclado do JAVA Util, ira aparecer: <List<E>> , posso pedir a ARRAY de Tem assim: <List<Tema>> e Import do Tema MODEL!! 
		
		return ResponseEntity.ok(repository.findAll());  //Atencao no OK: Escolher OBJETO BodyBuild!!
		
	}
	
	
	//Criando os End Points, e o Segundo seria @GetMapping do FindId=
	@GetMapping("/{id}")  // Primeiro ANUNCIO do ID que seria um tipo de PATH Variable!!
    public ResponseEntity<Tema> getById(@PathVariable long id){
		
	}
    
 
    
}
