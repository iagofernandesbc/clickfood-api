package br.com.clickfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Long> {

}
