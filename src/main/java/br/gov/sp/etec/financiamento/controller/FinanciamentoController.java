package br.gov.sp.etec.financiamento.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import br.gov.sp.etec.financiamento.model.Intent;
import br.gov.sp.etec.financiamento.repository.FinanciamentoRepository;

@Controller
public class FinanciamentoController {
	
	@Autowired
	FinanciamentoRepository repository;
			
	@GetMapping("/")	
	public ModelAndView home() {
		ModelAndView view = new ModelAndView("home");		
		List<Intent> intent = repository.findAll();
		view.addObject(new Intent());
		view.addObject("intent", intent);
		return view;
	}
	
	@GetMapping("/NovaIntent")	
	public String novaIntent() {

		return "new-intent";
	}

	@PostMapping("/salvar")
	public String salvar(Intent intencao) {
		repository.save(intencao);
		return "redirect:/";
	}
		
	@GetMapping("/detalhar/{id}")
	public String detalharIntent(@PathVariable Long id, Model model) {			
		Intent intent = repository.findById(id).get();
		model.addAttribute(intent);
		return "salvo"; 
	}	
	
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable Long id) {		
		repository.deleteById(id);
		return "redirect:/";
	}
	
}

