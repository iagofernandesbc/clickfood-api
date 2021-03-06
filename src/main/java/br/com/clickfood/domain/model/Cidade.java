package br.com.clickfood.domain.model;

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
public class Cidade {

	@EqualsAndHashCode.Include
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cidade")
	private Long id;
	
	@Column(name = "nm_cidade", length = 60, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(name = "id_estado", nullable = false, foreignKey = @ForeignKey(name = "FK_ESTADO"))
	private Estado estado;
	
}
