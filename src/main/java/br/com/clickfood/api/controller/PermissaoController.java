package br.com.clickfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickfood.domain.model.Permissao;
import br.com.clickfood.domain.repository.PermissaoRepository;

@RestController
@RequestMapping("/permissoes")
public class PermissaoController {

	@Autowired
	private PermissaoRepository permissaoRepository;

	@GetMapping
	public List<Permissao> listar() {
		return permissaoRepository.listar();
	}

	@GetMapping("/{id}")
	public ResponseEntity<Permissao> buscar(@PathVariable Long id) {
		Permissao permissao = permissaoRepository.buscar(id);
		if (permissao != null) {
			return ResponseEntity.ok(permissao);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	public Permissao salvar(@RequestBody Permissao permissao) {
		return permissaoRepository.salvar(permissao);
	}

	@PutMapping
	public ResponseEntity<Permissao> atualizar(@RequestBody Permissao permissao) {
		if (permissao != null && permissao.getId() != null) {
			permissao = permissaoRepository.salvar(permissao);
			return ResponseEntity.ok(permissao);
		}
		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Permissao> remover(@PathVariable Long id) {
		try {
			Permissao permissao = permissaoRepository.buscar(id);
			if (permissao != null) {
				permissaoRepository.remover(permissao);
				return ResponseEntity.noContent().build();
			}
			return ResponseEntity.notFound().build();
		} catch (DataIntegrityViolationException e) {
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}

}
