package br.com.clickfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickfood.domain.model.Cidade;
import br.com.clickfood.domain.repository.CidadeRepository;

@RestController
@RequestMapping("/cidades")
public class CidadeController {

	@Autowired
	private CidadeRepository cidaderepository;

	@GetMapping
	public List<Cidade> listar() {
		return cidaderepository.listar();
	}
	
	@GetMapping("/{id}")
	public Cidade buscar(@PathVariable Long id) {
		return cidaderepository.buscar(id);
	}

}
