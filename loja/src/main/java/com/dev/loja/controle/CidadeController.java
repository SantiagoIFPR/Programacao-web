package com.dev.loja.controle;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.dev.loja.modelos.Cidade;
import com.dev.loja.repositorios.CidadeRepository;
import com.dev.loja.repositorios.EstadoRepository;


@Controller
public class CidadeController {
	
	@Autowired
	private CidadeRepository repositoryCidade;
	
	@Autowired
	public EstadoRepository repositoryEstado;
	
	@GetMapping("/administrativo/cidade/listarCidade")
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("/administrativo/cidade/cidade");
		mv.addObject("cidade", repositoryCidade.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/cidade/adicionarCidade")
	public ModelAndView add(Cidade cidade) {
		ModelAndView mv = new ModelAndView("/administrativo/cidade/addcidade");
		mv.addObject("cidade", cidade);
		mv.addObject("estados", repositoryEstado.findAll());
		return mv;
	}
	
	@GetMapping("/administrativo/cidade/editarCidade/{id}")
	public ModelAndView editar(@PathVariable("id") long id) {
		Optional<Cidade> op = repositoryCidade.findById(id);
		Cidade cid = op.get();
		return add(cid);
	}
	
	@GetMapping("/administrativo/cidade/removerCidade/{id}")
	public ModelAndView remover(@PathVariable("id") long id) {
		Optional<Cidade> op = repositoryCidade.findById(id);
		Cidade cid = op.get();
		repositoryCidade.delete(cid);
		return listar();
	}
	
	@PostMapping("/administrativo/cidade/salvarCidade")
	public ModelAndView salvar(Cidade cidade) {
		repositoryCidade.save(cidade);
		return listar();
	}

}
