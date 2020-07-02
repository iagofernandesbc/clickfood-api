package br.com.clickfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
