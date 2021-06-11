package com.generation.blogPessoal.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.generation.blogPessoal.model.Usuario;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class UsuarioRepositoryTest {

	@Autowired
	private UsuarioRepositoryTest repositorio;

	@BeforeAll
	void start() {
		Usuario usuario = new Usuario();
		if(repositorio.findByUsuario(usuario.getUsuario())!=null)
			repositorio.save(usuario);

		usuario = new Usuario();
		if(repositorio.findByUsuario(usuario.getUsuario())!=null)
			repositorio.save(usuario);

		usuario = new Usuario();
		if(repositorio.findByUsuario(usuario.getUsuario())!=null)
			repositorio.save(usuario);
	}

	private void save(Usuario usuario) {
		// TODO Auto-generated method stub
		
	}

	private Object findByUsuario(String usuario) {
		// TODO Auto-generated method stub
		return null;
	}


	private Object findByUsuario() {
		// TODO Auto-generated method stub
		return null;
	}

	@Test
	public void findAllByUsuarioContainingIgnoreCaseRetornaTresContato() {

		List<Usuario> listaDeUsuarios = repositorio.findAllByUsuarioContainingIgnoreCase("Boaz");
		assertEquals(3, listaDeUsuarios.size());
	}

	private List<Usuario> findAllByUsuarioContainingIgnoreCase(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	@AfterAll
	public void end() {
		repositorio.deleteAll();
	}

	private void deleteAll() {
		// TODO Auto-generated method stub
		
	}

}