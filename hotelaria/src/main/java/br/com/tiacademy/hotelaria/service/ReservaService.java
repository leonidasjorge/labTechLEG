package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Reserva;

@Service
public class ReservaService extends CrudService<Reserva, Integer> {

	@Override
	protected Reserva editarEntidade(Reserva buscarId, Reserva entidade) {
		buscarId.setData_reserva(entidade.getData_reserva());
		buscarId.setData_entrada(entidade.getData_entrada());
		buscarId.setData_saida(entidade.getData_saida());
		buscarId.setSub_total(entidade.getSub_total());
		
		return buscarId;
	}

}
