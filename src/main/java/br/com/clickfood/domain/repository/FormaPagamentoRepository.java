package br.com.clickfood.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.clickfood.domain.model.FormaPagamento;

public interface FormaPagamentoRepository extends JpaRepository<FormaPagamento, Long> {

}
