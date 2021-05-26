//Repository serve Para Comunicacao com o BANCO DE DADOS!!!

package com.generation.blogPessoal.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.blogPessoal.model.Postagem;

// feito Extends para herdar, de um Repositorio de um FRAMEWORK do JPA

@Repository  // Anotacao , indicando que se trata de um Repository que e de outra classe!!
public interface PostagemRepository extends JpaRepository<Postagem, Long> {
//adionado qual o tipo de entide esta neste Trabalho, no caso sao: T[Postagem,] e qual tipo de ID: [Long] com letra maiuscula!!
	//ATENCAO: A [Postagem] e o mesmo nome do MODEL arquivo---> Postagem.java
	public List<Postagem> findAllByTituloContainingIgnoreCase (String titulo); //E o nome do metodo, vai ser extatamente o que ele faz que sera [findAllByTituloContainingIgnoreCase]
	// referente ao (String titulo); e uma declaracao de Variavel TITULO!!
	
	
	
	
	
	
	
	// Observacao: findAllByTituloContainingIgnoreCase] ele pega o Titulo do Postagem.java e o Hibernete deixa usar Letra maiuscula.
	
	
				//Referencias
	// Contain = e o LIKE do MySQL
	//IgnoreCase = padroniza tudo mesmo sendo maiusculo ou ao contrario.

}
