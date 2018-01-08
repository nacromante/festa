package com.algaworks.festa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.algaworks.festa.model.Usuario;
import com.algaworks.festa.repository.ConvidadosRep;

@Controller
//@RequestMapping("/convidados")
public class LoginController {
	
	@Autowired
	private ConvidadosRep convidados;
	
	public LoginController() {
	}
	
	@GetMapping("/buffet")
	public ModelAndView iniciar(Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("Login");
		modelAndView.addObject("usuario", usuario);
	
		return modelAndView;
	}
	
	
	
	
	
	

}
