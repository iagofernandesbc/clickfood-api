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
import br.com.clickfood.domain.model.Cozinha;
import br.com.clickfood.domain.repository.CozinhaRepository;
import br.com.clickfood.domain.service.CozinhaService;

@RestController
@RequestMapping("/cozinhas")
public class CozinhaController {

	@Autowired
	private CozinhaRepository cozinhaRepository;

	@Autowired
	private CozinhaService cozinhaService;

	@GetMapping
	public List<Cozinha> listar() {
		return cozinhaRepository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Cozinha> buscar(@PathVariable Long id) {
		Cozinha cozinha = cozinhaRepository.buscar(id);
		
		if (cozinha != null) {
			return ResponseEntity.status(HttpStatus.OK).body(cozinha);	
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cozinha adicionar(@RequestBody Cozinha cozinha) {
		return cozinhaService.salvar(cozinha);
	}

	@PutMapping("/{id}")
	public ResponseEntity<Cozinha> atualizar(@PathVariable Long id, @RequestBody Cozinha cozinha) {
		Cozinha cozinhaAtual = cozinhaRepository.buscar(id);
		
		if (cozinhaAtual != null) {
			BeanUtils.copyProperties(cozinha, cozinhaAtual, "id");
			cozinhaAtual = cozinhaService.salvar(cozinhaAtual);
			return ResponseEntity.status(HttpStatus.OK).body(cozinhaAtual);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Cozinha> remover(@PathVariable Long id) {
		try {
			cozinhaRepository.remover(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();

		} catch (EntidadeNaoEncontradaException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

		} catch (EntidadeEmUsoException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
