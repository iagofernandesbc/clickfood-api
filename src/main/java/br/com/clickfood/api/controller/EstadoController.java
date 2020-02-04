package br.com.clickfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickfood.domain.model.Estado;
import br.com.clickfood.domain.repository.EstadoRepository;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.listar();
	}
	
	@GetMapping("/{id}")
	public Estado buscar(@PathVariable Long id) {
		return estadoRepository.buscar(id);
	}

}
