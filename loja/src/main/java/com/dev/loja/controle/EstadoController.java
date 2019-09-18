package com.dev.loja.controle;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.loja.modelos.Estado;
import com.dev.loja.repositorios.EstadoRepository;


@Controller
public class EstadoController {
	@Autowired
	public EstadoRepository repository;
	
	@GetMapping("/administrativo/estado/listaEstado")
	public ModelAndView lista() {
		ModelAndView mv = new ModelAndView("/administrativo/estado/estado");
		List<Estado> estado = repository.findAll();
		mv.addObject("estados", estado);
		return mv;
	}
	
	@GetMapping("/administrativo/estado/adicionarEstado")
	public ModelAndView add(Estado estado) {
		ModelAndView mv = new ModelAndView("/administrativo/estado/addestado");
		mv.addObject("estado", estado);
		return mv;
	}
	
	@GetMapping("/administrativo/estado/editarEstado/{id}")
	public ModelAndView editar(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		return add(e);
		
	}
	
	@GetMapping("/administrativo/estado/removerEstado/{id}")
	public ModelAndView remover(@PathVariable("id") Long id){
		Optional<Estado> estado = repository.findById(id);
		Estado e = estado.get();
		repository.delete(e);
		return lista();
		
	}
	@PostMapping("/administrativo/estado/salvarEstado")
	public ModelAndView salvar(@Valid Estado estado, BindingResult result ) {
		System.out.println("Chegou aquii");
		if(result.hasErrors()) {
			
		}
		repository.saveAndFlush(estado);
		return lista();
	}

}
