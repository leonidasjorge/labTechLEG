package br.com.tiacademy.hotelaria.service;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.HospedeReserva;

@Service
public class HospedeReservaService extends CrudService<HospedeReserva, Integer> {

	@Override
	protected HospedeReserva editarEntidade(HospedeReserva buscarId, HospedeReserva entidade) {
		
		buscarId.setHospede(entidade.getHospede());
		buscarId.setReserva(entidade.getReserva());
		buscarId.setTipoHospede(entidade.getTipoHospede());
		
		return buscarId;
	}

}
