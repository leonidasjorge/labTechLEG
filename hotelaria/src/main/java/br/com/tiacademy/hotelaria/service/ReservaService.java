package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Reserva;

@Service
public class ReservaService extends CrudService<Reserva, Integer> {

	@Override
	protected Reserva editarEntidade(Reserva buscarId, Reserva entidade) {
		
		buscarId.setId(entidade.getId());
		buscarId.setDataReserva(entidade.getDataReserva());
		buscarId.setDataEntrada(entidade.getDataEntrada());
		buscarId.setDataSaida(entidade.getDataSaida());
		buscarId.setQuarto(entidade.getQuarto());

		buscarId.getHospedes().clear();
		buscarId.getHospedes().addAll(entidade.getHospedes());
		
		return buscarId;
	}

}
