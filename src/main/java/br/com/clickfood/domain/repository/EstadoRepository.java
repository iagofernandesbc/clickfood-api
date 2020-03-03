package br.com.clickfood.domain.repository;

import java.util.List;

import br.com.clickfood.domain.model.Estado;

public interface EstadoRepository {
	
	List<Estado> listar();

	Estado buscar(Long id);

	Estado salvar(Estado estado);

	void remover(Long id);
	
}
