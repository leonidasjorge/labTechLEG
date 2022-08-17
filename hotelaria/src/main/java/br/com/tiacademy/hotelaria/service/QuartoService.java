package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Quarto;

@Service
public class QuartoService extends CrudService<Quarto, Integer> {

	@Override
	protected Quarto editarEntidade(Quarto buscarId, Quarto entidade) {
		
		buscarId.setTipo(entidade.getTipo());
		buscarId.setValor_diaria(entidade.getValor_diaria());
		
		return buscarId;
	}

}
