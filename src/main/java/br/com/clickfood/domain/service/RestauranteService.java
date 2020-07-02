package br.com.clickfood.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import br.com.clickfood.domain.exception.EntidadeEmUsoException;
import br.com.clickfood.domain.exception.EntidadeNaoEncontradaException;
import br.com.clickfood.domain.model.Cozinha;
import br.com.clickfood.domain.model.Restaurante;
import br.com.clickfood.domain.repository.CozinhaRepository;
import br.com.clickfood.domain.repository.RestauranteRepository;

@Service
public class RestauranteService {

	@Autowired
	private RestauranteRepository restauranteRepository;

	@Autowired
	private CozinhaRepository cozinhaRepository;

	public Restaurante salvar(Restaurante restaurante) {
		Long cozinhaId = restaurante.getCozinha().getId();
		Cozinha cozinha = cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontradaException(
				String.format("Não existe cadastro de cozinha com código %d", cozinhaId)));

		restaurante.setCozinha(cozinha);

		return restauranteRepository.save(restaurante);
	}

	public void remover(Long id) {
		try {
			restauranteRepository.deleteById(id);
	
		} catch (EmptyResultDataAccessException e) {
			throw new EntidadeNaoEncontradaException(
					String.format("Não existe um cadastro de cidade com código %d", id));

		} catch (DataIntegrityViolationException e) {
			throw new EntidadeEmUsoException(
					String.format("Cidade de código %d não pode ser removida, pois está em uso", id));
		}
	}

}