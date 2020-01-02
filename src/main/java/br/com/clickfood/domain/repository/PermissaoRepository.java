package br.com.clickfood.domain.repository;

import java.util.List;

import br.com.clickfood.domain.model.Permissao;

public interface PermissaoRepository {
	
	List<Permissao> listar();

	Permissao buscar(Long id);

	Permissao salvar(Permissao permissao);

	void remover(Permissao permissao);

}
