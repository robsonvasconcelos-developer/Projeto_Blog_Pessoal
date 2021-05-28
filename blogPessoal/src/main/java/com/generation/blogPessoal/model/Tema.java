    // Este e a Segunda Camada MODEL feita para o TEMA!!!!!


package com.generation.blogPessoal.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity     					//Escolhido a Primeira opcao de Biblioteca do JAVAX!!!
@Table(name = "tb_tema")      //Anotacao, para Criar a Tabela e dar uma Nome para a mesma! Biblioteca JAVAX tambem!
public class Tema {

	//Criando Atributos variaveis, com Primary Key ID com long!
	
	@Id  // Na Anotacao: @Id e @GeneratedValue sao JAVAX!
	@GeneratedValue(strategy = GenerationType.IDENTITY)  // no Body () importar "Strategy"! depois do = apertar crtl + soace = primeira opcao e segunda!>
	private long id;     // o @GeneratedValue serve para gerar PK automatico no BD!
	@NotNull    //Javax
	private String descriocao;
	@OneToMany(mappedBy = "tema", cascade = CascadeType.ALL )   //Crinado um RELACIONAMENTO!  //dentro de () colocar parametro: mappedBy com a CLASSE de qual atributo estamos Mapeando: "tema"  da tabela de postagem! e ouitro Atributo chamado CASCADE!
	//Linha ANTERIOR: o comando: "tema", cascade = CascadeType.ALL  FAZ que se deletar o TEMA, deletara todas as Postagens!!!!
	@JsonIgnoreProperties("tema")    //Dentro do () apartir de qual PROPRIEDADE sera Ignorado da Tabela Postagem!!   Sera IGNORADO o Atributo "tema" da Tabela POSTAGEM, para nao Duplicar!!
	private List<Postagem> postagem; // Isso e um atributo ARRAY nomeado como List e List  foi importado da Biblioteca: import java.util.List;
	
	
	
	
	//Depois de atributos, adicionando os Getters e Setters e selecionar Todos!
	//Atalho de Getters e Setters= Command + 3 + Digitar: ggas !!!
	
	public long getId() { // o @GeneratedValue serve para gerar PK automatico no BD!
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDescriocao() {
		return descriocao;
	}
	public void setDescriocao(String descriocao) {
		this.descriocao = descriocao;
	}
	public List<Postagem> getPostagem() {
		return postagem;
	}
	public void setPostagem(List<Postagem> postagem) {
		this.postagem = postagem;
	}
	

	
	
	
	
	
}
