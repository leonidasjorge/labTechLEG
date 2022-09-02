package br.com.tiacademy.hotelaria.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.Hospedagem;
import br.com.tiacademy.hotelaria.dto.HospedagemDTO;
import br.com.tiacademy.hotelaria.repository.ReservaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class HospedagemConverter implements CrudConverter<Hospedagem, HospedagemDTO> {

	private final ReservaRepository reservaRepository;
	
	private final ReservaConverter reservaConverter;
	
	@Override
	public HospedagemDTO entidadeParaDto(Hospedagem entidade) {

		var dto = new HospedagemDTO();
		
		dto.setId(entidade.getId());
		dto.setCheckIn(entidade.getCheckIn());
		dto.setCheckOut(entidade.getCheckOut());
		
		dto.setReservaDTO(reservaConverter.entidadeParaDto(entidade.getReserva()));

		return dto;
		
	}

	@Override
	public Hospedagem dtoParaEntidade(HospedagemDTO dto) {

		var hospedagem = new Hospedagem();
		
		hospedagem.setId(dto.getId());
		hospedagem.setCheckIn(dto.getCheckIn());
		hospedagem.setCheckOut(dto.getCheckOut());
		
		hospedagem.setReserva(reservaRepository.findById(dto.getReservaId()).orElse(null));
		
		return hospedagem;
	}

}
