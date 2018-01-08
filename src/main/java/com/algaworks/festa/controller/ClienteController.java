package com.algaworks.festa.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Valid;
import javax.validation.Validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.algaworks.festa.model.Cliente;
import com.algaworks.festa.model.Endereco;
import com.algaworks.festa.model.Sexo;
import com.algaworks.festa.model.StatusStep;
import com.algaworks.festa.model.Step;
import com.algaworks.festa.model.Usuario;
import com.algaworks.festa.repository.ClientesRep;

@Controller
@RequestMapping("/cliente")
public class ClienteController {
	@Autowired
    private Validator validator;
	
	@Autowired
	private ClientesRep clientesRep;
	
	private int pStep = 1;
	private List<Step> steps;

	private String senhaRepita;
	
	public ClienteController() {
		steps = new ArrayList<Step>();
		steps.add(new Step(1,"Dados Pessoais",StatusStep.INCOMPLETO));
		steps.add(new Step(2,"Endereço",StatusStep.AUSENTE));
		steps.add(new Step(3,"Dados de Acesso",StatusStep.AUSENTE));
		
	}
	
//	@PostMapping("/salvar")
//	public ModelAndView salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {
//		System.out.println("conv id ="+ cliente.getId());
//		if(result.hasErrors())
//			return cadastro(cliente);
//		attr.addFlashAttribute("msg", "Cliente salvo com sucesso!");
//		if(cliente.getId() != null)
//			attr.addFlashAttribute("cliente", cliente);
//		clientesRep.save(cliente);
//		return new ModelAndView("redirect:/cadastro");
//
//	}
	@GetMapping("/cadastro")
	public ModelAndView cadastro(Cliente cliente, Endereco endereco, Usuario usuario) {
		ModelAndView modelAndView = new ModelAndView("Cliente");
		List<Sexo> sexos = Arrays.asList(Sexo.values());
		modelAndView.addObject("cliente", cliente);
		modelAndView.addObject("endereco", endereco);
		modelAndView.addObject("usuario", usuario);
		modelAndView.addObject("sexos", sexos);
		modelAndView.addObject("steps", steps);
		modelAndView.addObject("pStep", pStep);
//		modelAndView.addObject("senhaRepita", senhaRepita);
		modelAndView.getModel().put("senhaRepita", senhaRepita);
		System.out.println("pstep: "+pStep);
		return modelAndView;
	}
	
	@PostMapping("/cadastro/proximo")
	public ModelAndView proximo(@Valid Cliente cliente, BindingResult resultCli, 
			Endereco endereco, BindingResult resultEnd,
			Usuario usuario, BindingResult resultUsu,
			Model model) {
		
		boolean temErro = false;
		BindingResult result = resultCli;
		Object obj = endereco;
		if(!resultCli.hasErrors()) {
			if(pStep == 2) {
				obj = endereco;
				result = resultEnd;
			}
			if(pStep == 3) {
				obj = usuario;
				if(!model.asMap().get("senhaRepita").equals(usuario.getSenha()))
					resultUsu.reject("senha", "As senhas não conferem");
				result = resultUsu;
			}
			if(pStep > 1 && pStep < 4)
				validator.validate(obj, result);
			if(result.hasErrors()) 
				temErro = true;
			if(!temErro) {
				passaEtapa();
			}
		}
		return cadastro(cliente, endereco, usuario);	
	}

	private void passaEtapa() {
		if(!steps.get(pStep-1).getStatus().equals(StatusStep.COMPLETO)) {
			steps.get(pStep-1).setStatus(StatusStep.COMPLETO);
			steps.get(pStep).setStatus(StatusStep.INCOMPLETO);
		}
		pStep = pStep + 1;
	}
	@PostMapping("/cadastro/anterior")
	public ModelAndView anterior(Cliente cliente, Endereco endereco, Usuario usuario) {
		
		pStep = pStep - 1;
		
		return cadastro(cliente, endereco, usuario);	
	}

	public int getpStep() {
		return pStep;
	}

	public void setpStep(int pStep) {
		this.pStep = pStep;
	}

	public List<Step> getSteps() {
		return steps;
	}

	public void setSteps(List<Step> steps) {
		this.steps = steps;
	}

	
	
	

}
