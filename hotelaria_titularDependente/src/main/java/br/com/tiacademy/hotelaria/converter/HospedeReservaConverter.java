package br.com.tiacademy.hotelaria.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.HospedeReserva;
import br.com.tiacademy.hotelaria.dto.HospedeReservaCriarDTO;
import br.com.tiacademy.hotelaria.dto.HospedeReservaDTO;
import br.com.tiacademy.hotelaria.repository.HospedeRepository;
import br.com.tiacademy.hotelaria.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class HospedeReservaConverter implements CrudConverter<HospedeReserva, HospedeReservaDTO> {

	private final HospedeConverter hospedeConverter;
	private final ReservaConverter reservaConverter;
	
	private final HospedeRepository hospedeRepository;
	private final ReservaRepository reservaRepository;
	
	@Override
	public HospedeReservaDTO entidadeParaDto(HospedeReserva entidade) {
		
		var dto = new HospedeReservaDTO();
		
		dto.setHospede(hospedeConverter.entidadeParaDto(entidade.getHospede()));
		dto.setReserva(reservaConverter.entidadeParaDto(entidade.getReserva()));
		
		dto.setTipoHospede(entidade.getTipoHospede());
		
		return dto;
	}

	@Override
	public HospedeReserva dtoParaEntidade(HospedeReservaDTO dto) {

		var hospedeReserva = new HospedeReserva();
		
		hospedeReserva.setHospede(hospedeRepository.findById(dto.getHospedeId()).orElse(null));
		hospedeReserva.setReserva(reservaRepository.findById(dto.getReservaId()).orElse(null));
		
		hospedeReserva.setTipoHospede(dto.getTipoHospede());
		
		return hospedeReserva;
	}

	public HospedeReserva dtoCriarParaEntidade(HospedeReservaCriarDTO dto) {
		
		var hospedeReserva = new HospedeReserva();
		
		hospedeReserva.setHospede(hospedeRepository.findById(dto.getHospedeId()).orElse(null));
		hospedeReserva.setReserva(reservaRepository.findById(dto.getReservaId()).orElse(null));
		
		return hospedeReserva;
	}
	
}
