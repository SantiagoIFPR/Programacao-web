package com.cadastro.cadastroCliente.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cadastro.cadastroCliente.models.Cliente;

@Controller
public class CadastroController {
	@RequestMapping("/cadastro")
	public String dadoscliente() {
		return "dadoscliente";
	}
	@RequestMapping(value= "/cadastrarCliente", method = RequestMethod.POST)
	public ModelAndView cadastrarCliente(Cliente cliente) {
		ModelAndView viewRetorno = new ModelAndView("dadoscliente");
		viewRetorno.addObject("cliente", cliente);
		return viewRetorno;
	}
}
