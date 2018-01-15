package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festa.model.Usuario;
import com.algaworks.festa.repository.UsuariosRep;

@Controller
public class RecuperaController {
	
	@Autowired
	private UsuariosRep usuariosRep;
	
	public RecuperaController() {
		System.out.println("entrou recupera");
	}
	
	@RequestMapping("/buffet/recupera")
	public String iniciar() {
		return "Recupera";
	}

	@RequestMapping(value="/buffet/recupera", method=RequestMethod.POST)
	public String recuperar(@RequestParam("email") String email, RedirectAttributes attributes) {
		Usuario usuario = null;
		if(email == null || email.isEmpty()) {
			return redirecionaComParametro("msgError","Entre com o e-mail", "/buffet/recupera", attributes);
		}else {
			usuario = usuariosRep.findByLogin(email);
			if(usuario == null) {
				attributes.addFlashAttribute("msgError", "E-mail não cadastrado no sistema");
				return redirecionaComParametro("email",email,"/buffet/recupera", attributes);
			}
		}
		return redirecionaComParametro("msgEmailEnviado", "Um E-mail foi enviado para "+usuario.getLogin()+", confira sua caixa de entrada.","/buffet", attributes);
	}

	private String redirecionaComParametro(String variavel, String valor, String caminho, RedirectAttributes attributes) {
		attributes.addFlashAttribute(variavel, valor);
		return "redirect:" + caminho;
	}
	
	
	
	
	
	

}
