package br.com.clickfood.domain.repository;

import java.util.List;

import br.com.clickfood.domain.model.Cozinha;

public interface CozinhaRepository {

	List<Cozinha> listar();

	Cozinha buscar(Long id);

	Cozinha salvar(Cozinha cozinha);

	void remover(Long id);

}
