package com.algaworks.festa.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festa.model.Convidado;
import com.algaworks.festa.model.Sexo;
import com.algaworks.festa.repository.ConvidadosRep;

@Controller
//@RequestMapping("/convidados")
public class ConvidadosController {
	
	@Autowired
	private ConvidadosRep convidados;
	
	public ConvidadosController() {
	}
	
	@GetMapping("/convidados")
	public ModelAndView listar(Convidado convidado) {
		ModelAndView modelAndView = new ModelAndView("ListaConvidados");
		modelAndView.addObject("convidados", convidados.findAll());
		modelAndView.addObject(convidado);
	
		return modelAndView;
	}
	
	@PostMapping("/convidado/salvar")
	public ModelAndView salvar(@Valid Convidado convidado, BindingResult result, RedirectAttributes attr) {
		System.out.println("conv id ="+ convidado.getId());
		if(result.hasErrors())
			return cadastro(convidado);
		convidado.setDataPresencaConfirmada(new Date());
		attr.addFlashAttribute("msg", "Convidado salvo com sucesso!");
		if(convidado.getId() != null)
			attr.addFlashAttribute("convidado", convidado);
		convidados.save(convidado);
		return new ModelAndView("redirect:/cadastro");

	}
	@GetMapping("/add/{id}")
	public String add(@PathVariable("id") Long id, RedirectAttributes attr) {
		Convidado convidado = convidados.findOne(id);
		if(convidado != null)
			attr.addFlashAttribute("convidado", convidado);
		return "redirect:/cadastro";
	} 
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {
		convidados.delete(id);
		return "redirect:/convidados";
	}
	
	@GetMapping("/cadastro")
	public ModelAndView cadastro(Convidado convidado) {
		ModelAndView modelAndView = new ModelAndView("Convidado");
		List<Sexo> sexos = Arrays.asList(Sexo.values());
		modelAndView.addObject("convidado", convidado);
		modelAndView.addObject("sexos", sexos);
		return modelAndView;
	}
	
	
	
	

}
