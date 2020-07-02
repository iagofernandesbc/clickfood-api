package br.com.clickfood.domain.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.Cozinha;

public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

	List<Cozinha> findByNome(String nome);

}
