package br.com.clickfood.domain.repository;

import java.util.List;

import br.com.clickfood.domain.model.Restaurante;

public interface RestauranteRepository {

	List<Restaurante> listar();

	Restaurante buscar(Long id);

	Restaurante salvar(Restaurante restaurante);

	void remover(Long id);

}
