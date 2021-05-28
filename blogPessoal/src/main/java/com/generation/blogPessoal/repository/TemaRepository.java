package com.generation.blogPessoal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.blogPessoal.model.Tema;

//Primeira coisa e HERDAR do Pacotes JPA e em seguida colocar o Tema + crlt + space = TemaRepository !! 
public interface TemaRepository extends JpaRepository<TemaRepository, Long> {  // O "Long" com L maiusculo, indica qual o TIPO do ID!!
	
	//Metodo QUERY para busca pelo Tema!
	public List<Tema> findAllByDescricaoContainingIgnoreCase(String descricao) ; // Import do List = e do JAVA.UTIL!!!

	// DENTRO de () ira receber como Parametro: String descricao !!
	
}
