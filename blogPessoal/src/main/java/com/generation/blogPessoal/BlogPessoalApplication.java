// Esse e o Projeto!! Para rodar e Se manter em funcionamento!

/*LEMBRANDO que para colocar ESSA Aplicacao para RODAR o caminho e o seguintye=
em BlogPessoalApplication.java + Botao direito do MOUSE + Click RUN AS + Click em "1 Java Aplication"
*/
package com.generation.blogPessoal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
@RestController
@RequestMapping("/")
public class BlogPessoalApplication {

	 	@GetMapping
	    public ModelAndView swaggerUi() {
	        return new ModelAndView("redirect:/swagger-ui/");
	    }

	public static void main(String[] args) {
		SpringApplication.run(BlogPessoalApplication.class, args);
	}
}