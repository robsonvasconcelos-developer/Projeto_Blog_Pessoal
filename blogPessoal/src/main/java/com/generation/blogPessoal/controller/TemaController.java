// Segunda Camada CONTROLLER do projeto !!

// OS Metodos END - POINT ficam aqui na Camada de Controle!

package com.generation.blogPessoal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.Tema;
import com.generation.blogPessoal.repository.TemaRepository;

//Para falar que isso SRIA UM CONTROLLER Necessarios criar varios END Points!!

@RestController				//Primeiro anotacao de End Point! Para decrarar que isso E` um CONTROLLER!
@CrossOrigin(origins = "*", allowedHeaders = "*")					// Ver tudo , independente da Origem, que estamos consumindo
@RequestMapping("/tema")   // informando o Caminho do End Point para testar no POSTMAN!
public class TemaController {
	
	//Para INjetar o SERVICO, usarei o @Autowired !!
	@Autowired
	private TemaRepository repository;
	
	//Criando os End Points, e o primeiro seria @GetMapping
	@GetMapping // para fazer a tarefa como se fosse GetAll!
	public ResponseEntity<List<Tema>> getAll(){//(x?) chamo o GetAll () e nao receber mada como parametro, mas, ABRE Chave e Fecha chaves {}
		//sobre a linha ACIMA: <List> ao chamar a List com ATALHO do Teclado do JAVA Util, ira aparecer: <List<E>> , posso pedir a ARRAY de Tem assim: <List<Tema>> e Import do Tema MODEL!! 
		return ResponseEntity.ok(repository.findAll());
		
		//return ResponseEntity.ok(repository.findAll());  //Atencao no OK: Escolher OBJETO BodyBuild!!
		
	}
	
	
	//Criando os End Points, e a Segunda seria anotacao @GetMapping do FindId=
	@GetMapping("/{id}")  // Primeiro ANUNCIO do ID que seria um tipo de PATH Variable!!
    public ResponseEntity<Tema> getById(@PathVariable long id){
		return repository.findById(id).map(resp -> ResponseEntity.ok(resp))
				.orElse(ResponseEntity.notFound().build());
//Metodo de Anotacao acima, traz a pesquisa pelo ID!
		
	}
    
	//Agora feito um FindByName!!
@GetMapping("/nome/{nome}")       //feito direferente do ID, para nao causa conflito!	
	public ResponseEntity<List<Tema>>  getByName(@PathVariable String nome){// feito do Tipo List/ARRAY, porque tera mais de 1 NOME!!    //Nome do Metodo E` getByName e receber como parametro dentro da (), uma STRING: @PathVariable String nome, depois Abrir e fechar CHAVES{}!
		return ResponseEntity.ok(repository.findAllByDescricaoContainingIgnoreCase(nome)); // dentro da BODY (), trazer a lista de tudo que encontrei!


}


	// Agora Metodo de Anotacao End Point der POST=
@PostMapping
public ResponseEntity<Tema> post (@RequestBody Tema tema ){ //deposis do @RequestBody o Tema e da CLASS model e o "tema", e` o nome que dei ao OBJETO!
	 return ResponseEntity.status(HttpStatus.CREATED)
			 .body(repository.save(tema));  // Devolvendo um ResponseEntity!  //
	
	
	
	
}

@PostMapping
public ResponseEntity<Tema> put (@RequestBody Tema tema ){ //deposis do @RequestBody o Tema e da CLASS model e o "tema", e` o nome que dei ao OBJETO!
	 return ResponseEntity.ok(repository.save(tema));  // Devolvendo um ResponseEntity!  //
	
}


	// Metodo de Anotacao End Point der Delete=
	
@DeleteMapping("/{id}")
	public void delete(@PathVariable long id) {
		repository.deleteById(id);
	
	
}
	
	// Caminho para teste no Postman: http://localhost:8080/tema =

    
}
