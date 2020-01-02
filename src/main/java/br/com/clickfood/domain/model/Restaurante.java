package br.com.clickfood.domain.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_restaurante")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_cozinha", nullable = false, foreignKey = @ForeignKey(name = "FK_COZINHA"))
	private Cozinha cozinha;

	@Column(name = "nm_restaurante", length = 60, nullable = false)
	private String nome;

	@Column(name = "vl_taxa_frete")
	private BigDecimal taxaFrete;

}