package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Hospede;

@Service
public class HospedeService extends CrudService<Hospede, Integer>{

	@Override
	protected Hospede editarEntidade(Hospede buscarId, Hospede entidade) {
		
		buscarId.setCpf(entidade.getCpf());
		buscarId.setDataNascimento(entidade.getDataNascimento());
		buscarId.setNome(entidade.getNome());
		buscarId.setSobrenome(entidade.getSobrenome());
		buscarId.setTelefone(entidade.getTelefone());

		return buscarId;
	}
	
}
