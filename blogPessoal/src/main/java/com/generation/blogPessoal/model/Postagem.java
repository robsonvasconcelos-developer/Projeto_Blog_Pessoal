//Esse e o MODEL do Projeto e que eu Criei, totalmente Manualmente!!!!!

package com.generation.blogPessoal.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

//import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.istack.NotNull;

/* "Anotacoes" e Parametros que colocamos encima das Classes e das propriedades, que 
define um certo tipo de comportamento para elas
*/

// A primeira ANOTACAO e o @entity e em seguida chamar o "IMPORT"=

@Entity 
// indica que essa CLASS sera uma Entidade do JPA: Hibernate

// A Segunda Anoitacao e o @table da mesma Biblioteca, chamada = Persistence
@Table(name = "postagem") /*adicionado o "()", manualmente.*/    /*Estou dizendo que esta ENTIDADE dentro do BD
, ela ira virar uma Tabela!! E dentro das "()" coloquei o parametro "name =" para dar
o nome da TABELa "postagem"  */
public class Postagem {
	
	
							//Anotacao : que Gera o Automaticamente o ID!!!
	@Id
	
	@GeneratedValue(strategy = GenerationType.IDENTITY ) // parametro STRATEGY e utilizamos o AUTO Generation TYPE, do tipo .IDENTITY!!
	//como o ID ira se comportar dentro da Base de dados! @GeneratedValue para gerar Valor
	private long id; //acima, foi criado um Atributo de Anotacao para o ID!
	
	@NotNull
	@Size(min = 5, max = 100)
	private String titulo; //Anotacao de @NotNull para que o Usuario, nao se esqueca do Titulo!!
	
	@NotNull
	@Size(min = 5, max = 100) // "()" aqui dentro foi definido o Parametro de CARACTERES!!
	private String texto;
	
					// Anotacao: Que Gera data Atual Automaticamnete!!!
	@Temporal(TemporalType.TIMESTAMP)
	// Foi importado a biblioteca UTIL no "date"
	private Date date = new java.sql.Date(System.currentTimeMillis());/*
	Acima depois do "=" foi declarado a funcao para fazer a leitura da dara atual*/
	
	

	                  //Inserido TODOS os getters and Setter
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getTexto() {
		return texto;
	}
	public void setTexto(String texto) {
		this.texto = texto;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	
	//Adicionando Getters e Setters para TEMA "private Tema tema;"!
@ManyToOne         ////Criando um RELACIONAMENTO das tabelas Postagem e Tema!!
@JsonIgnoreProperties("postagem")   // Escrever ate @JsonIg + Crtl + space =- primeira opcao!   /// No parametro dentro de () o que ira IGNORAR dentro de postagem da List ARRAY!! Como string, para nao ter conflito de INFOR!!!
private Tema tema;      // Explicando: Tema seria a CLASS e em seguida o tema seria o ATRIBUTO!!!

public Tema getTema() {
	return tema;
}
public void setTema(Tema tema) {
	this.tema = tema;
} //Conolocar o Mouse encima de "Tema" marcado em Vermelho e criar uma CLASS automaticamente com nome : TEMA!!

	
	
	
	//Pronto!! Classe Crianda!!
	
	/*Agora para que esta CLASSE seja INTERPRETADA no BANCO DE DADOS, ou seja, para o JPA
	HIpernate consiga entender esta CLASSE, como uma ENTIDADE e TEMOS que inserir "Algumas anotacoes"
	EXEMPLO de ANOTACOES, abaixo do IMPORT, no Topo da Classe!!!!!
	*/
	

	
	/*
	 * Explicacao MAIS Completa=
	 * No BANCO DE DADOS o seguite comando:
	 * 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY ) 
	private long id;
	      Se torna uma PRIMARY KEY!!
	      
	      E assim, ficou a ENTIDADE de postagem!!!
	      
	      ATENCAO: Para testar o Projeto INICIAL dessa CLASS ir em {Aplication.java} - Botao direito do MOUSE ---> Run As --> Click em 1 Java Aplication!!
	      
	      E abaixo no CONSOLE ira mostrar o INICIO do Projeto Na PORTA 8080 (HTTP)!!
	 */
	
	
}
