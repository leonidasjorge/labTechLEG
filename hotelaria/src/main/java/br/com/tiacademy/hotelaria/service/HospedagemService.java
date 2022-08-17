package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Hospedagem;

@Service
public class HospedagemService extends CrudService<Hospedagem, Integer> {

	@Override
	protected Hospedagem editarEntidade(Hospedagem buscarId, Hospedagem entidade) {
		buscarId.setCheck_in(entidade.getCheck_in());
		buscarId.setCheck_out(entidade.getCheck_out());
		buscarId.setValor_total(entidade.getValor_total());
		
		return buscarId;
	}

}
