package br.com.clickfood.api.controller;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickfood.domain.exception.EntidadeEmUsoException;
import br.com.clickfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.clickfood.domain.model.Estado;
import br.com.clickfood.domain.repository.EstadoRepository;
import br.com.clickfood.domain.service.EstadoService;

@RestController
@RequestMapping("/estados")
public class EstadoController {

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private EstadoService estadoService;

	@GetMapping
	public List<Estado> listar() {
		return estadoRepository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Estado> buscar(@PathVariable Long id) {
		Estado estado = estadoRepository.buscar(id);

		if (estado != null) {
			return ResponseEntity.status(HttpStatus.OK).body(estado);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Estado adicionar(@RequestBody Estado estado) {
		return estadoService.salvar(estado);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Estado> atualizar(@PathVariable Long id, @RequestBody Estado estado) {
		Estado estadoAtual = estadoRepository.buscar(id);

		if (estadoAtual != null) {
			BeanUtils.copyProperties(estado, estadoAtual, "id");
			estadoAtual = estadoService.salvar(estadoAtual);
			return ResponseEntity.status(HttpStatus.OK).body(estadoAtual);
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> remover(@PathVariable Long id) {
		try {
			estadoService.remover(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
		}
	}

}
