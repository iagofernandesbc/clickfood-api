package br.com.clickfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.Permissao;

public interface PermissaoRepository extends JpaRepository<Permissao, Long> {

}
