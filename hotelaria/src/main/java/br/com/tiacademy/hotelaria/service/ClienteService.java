package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Cliente;

@Service
public class ClienteService extends CrudService<Cliente, Integer> {

	@Override
	protected Cliente editarEntidade(Cliente buscarId, Cliente entidade) {
		
		buscarId.setData_nascimento(entidade.getData_nascimento());
		buscarId.setNome(entidade.getNome());
		buscarId.setSobrenome(entidade.getSobrenome());
		buscarId.setTelefone(entidade.getTelefone());
		
		return buscarId;
	}

}
