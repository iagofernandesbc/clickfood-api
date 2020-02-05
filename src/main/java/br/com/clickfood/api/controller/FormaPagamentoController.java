package br.com.clickfood.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.clickfood.domain.model.FormaPagamento;
import br.com.clickfood.domain.repository.FormaPagamentoRepository;

@RestController
@RequestMapping("/formaspagamento")
public class FormaPagamentoController {

	@Autowired
	private FormaPagamentoRepository formaPagamentoRepository;

	@GetMapping
	public List<FormaPagamento> listar() {
		return formaPagamentoRepository.listar();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<FormaPagamento> buscar(@PathVariable Long id) {
		FormaPagamento formaPagamento = formaPagamentoRepository.buscar(id);
		
		if(formaPagamento != null) {
			return ResponseEntity.ok(formaPagamento);
		}else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public FormaPagamento salvar(@RequestBody FormaPagamento formaPagamento) {
		return formaPagamentoRepository.salvar(formaPagamento);
	}

}
