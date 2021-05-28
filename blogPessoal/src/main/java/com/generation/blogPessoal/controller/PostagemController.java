// O CONTROLLER serve para Comunicao com o Cliente(Postman, Angular etc)!!!!


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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.blogPessoal.model.Postagem;
import com.generation.blogPessoal.repository.PostagemRepository;




/*Necessario colocar algumas [anotacoes] na Cabeca do metodo, para
 * Para indicar que a CLASS, se trata de um CONTROLLER!!!
 * */

@RestController              //Essa ANOTACAO informa o SPRING, que se trata de uma CLASS controler!!
@RequestMapping("/postagens")         // Por qual RI essa CLASS sera acessada!! no () define com qual PARAMETRO sera Acessada a RI!!!
@CrossOrigin("*")       // para ser acessado de um API de Front End, EX: Angular!!! //("*") = serve para aceitar API de qualquer ORIGEM!!
public class PostagemController {
	
	
	
@Autowired	      /* como A "PostagemRepository" e uma INTERFACE, quem ira INSTANCIAR sera o @Autowired
Todos os servicos do Postagem sera feito no Controller!!Para ser possivel isar o servico todo da Interface	*/

//Colocando a CLASS do Repository dentro do Controler=
	private PostagemRepository repository; //Chamei o PostagemRepository e IMPORTEI e o "Repository" eo nome que Inventei!!
	

@GetMapping  // Tem que EXPOR para API que o Metodo FIND ALL!! E expor para funcionar!! com a ANOTACAO desta LINHA!

// Inserindo o Metodo de FIND ALL!!!!!
	public ResponseEntity<List<Postagem>> GetAll(){//Adicionado a "List" que retornou do tipo "Postagem"!!!
		// GetAll() seria o NOME do Metodo!!! {} e o parametro de CHAVES! 
		return ResponseEntity.ok(repository.findAll()); // E no retorno do Metodo! Sera recebido o Objeto : ResponseEntity e o ".ok()"passando a resposta do HTTP! E na () BODY fazer a requisicao de todas as Postagens!!
		
	}


					// Controller FinByid=
   
@GetMapping("/{id}") // Metodo para enviar Via HTTP para a API
public ResponseEntity<Postagem> GetById(@PathVariable long id){ //o @PathVariable chama a variavel ID para ("/{id}") na Pesquisa!!!
	return repository.findById(id) // comando que busca o ID!!
			.map(resp -> ResponseEntity.ok(resp)) // E tipo um IF // E um objeto do tipo Postagem
			.orElse(ResponseEntity.notFound().build()); // E tipo um Else
}



@GetMapping("/titulo/{titulo}") //Diferente do ID anterior, E gerado um SUB Caminho, para nao gerar conflito!!
public ResponseEntity<List<Postagem>> GetByTitulo(@PathVariable String titulo){
	return ResponseEntity.ok(repository.findAllByTituloContainingIgnoreCase(titulo)); // na URL na hora de pesquisar no Postman, ele Aceita com letra maiuscula ou minuscula!!!
}
					// END-POINT de Postagem!!
@PostMapping       //Ponto de Acesso, END-POINT!!
public ResponseEntity<Postagem> post (@RequestBody Postagem postagem){
	return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(postagem));
}

@PutMapping          //Anotacao de Atualizacao de DADOS!!
public ResponseEntity<Postagem> put (@RequestBody Postagem postagem){
	return ResponseEntity.status(HttpStatus.OK).body(repository.save(postagem));
}


				//Deleta o Comentario, DA Tabela chave Primaira ID, Completo!!
@DeleteMapping("/{id}")
public void delete(@PathVariable long id) {
	repository.deleteById(id);
}	


	



// Link para testar no POSTMAN = http://localhost:8080/postagens -- Para receber um OBJETO JSON no TESTE!!

// a ANOTACAO; @PathVariable serve para Capturar o Valor da URL, tanto do ID ou TITULO.

// O Objeto do OPTIONAL seria: .map(resp -> ResponseEntity.ok(resp))  //// e a LAMBDA Expression seria: (resp -> ResponseEntity.ok(resp)) - com devolucao da RESP de resposta  .OK !!!!
// se a RESP vier nulo, colocar: .orElse(ResponseEntity.notFound().build());

}
