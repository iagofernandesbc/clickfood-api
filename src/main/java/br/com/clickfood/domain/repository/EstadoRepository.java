package br.com.clickfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Long> {

}
