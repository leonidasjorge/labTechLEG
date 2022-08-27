package br.com.tiacademy.hotelaria.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.ReservaDTO;
import br.com.tiacademy.hotelaria.repository.QuartoRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Component
public class ReservaConverter implements CrudConverter<Reserva, ReservaDTO> {

	private final HospedeConverter hospedeConverter;
	private final QuartoConverter quartoConverter;
	
	private final QuartoRepository quartoRepository;
	
	@Override
	public ReservaDTO entidadeParaDto(Reserva entidade) {

		var dto = new ReservaDTO();
		
		dto.setId(entidade.getId());
		dto.setDataReserva(entidade.getDataReserva());
		dto.setDataEntrada(entidade.getDataEntrada());
		dto.setDataSaida(entidade.getDataSaida());
		
		dto.setQuarto(quartoConverter.entidadeParaDto(entidade.getQuarto()));

		dto.getHospedesDTO().addAll(entidade.getHospedes().stream()
														  .map(this.hospedeConverter::entidadeParaDto)
														  .collect(Collectors.toList()));
		
		return dto;
	}

	@Override
	public Reserva dtoParaEntidade(ReservaDTO dto) {

		var reserva = new Reserva();
		
		reserva.setId(dto.getId());
		reserva.setDataReserva(dto.getDataReserva());
		reserva.setDataEntrada(dto.getDataEntrada());
		reserva.setDataSaida(dto.getDataSaida());
		
		reserva.setQuarto(quartoRepository.findById(dto.getQuartoId()).orElse(null));

		var colecaoDeHospedes = dto.getHospedesDTO().stream()
										   .map(this.hospedeConverter::dtoParaEntidade)
										   .collect(Collectors.toList());
		
		reserva.getHospedes().addAll(colecaoDeHospedes);
		
		return reserva;
	}

}
