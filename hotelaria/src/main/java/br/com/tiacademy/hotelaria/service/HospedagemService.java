package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Hospedagem;
import br.com.tiacademy.hotelaria.emun.StatusQuarto;

@Service
public class HospedagemService extends CrudService<Hospedagem, Integer> {

	@Override
	protected Hospedagem editarEntidade(Hospedagem buscarId, Hospedagem entidade) {
		buscarId.setCheckIn(entidade.getCheckIn());
		buscarId.setCheckOut(entidade.getCheckOut());
		
		buscarId.setReserva(entidade.getReserva());
		buscarId.getReserva().getQuarto().setStatus(StatusQuarto.DISPONÍVEL);
		
		return buscarId;
	}

}
