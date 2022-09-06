 package br.com.tiacademy.hotelaria.converter;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.ReservaCriarDTO;
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
		dto.setDataEntrada(entidade.getDataEntrada());		
		dto.setDataReserva(entidade.getDataReserva());
		dto.setDataSaida(entidade.getDataSaida());
		dto.setSubTotal(entidade.getSubTotal());
		
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
		reserva.setDataEntrada(dto.getDataEntrada());
		reserva.setDataReserva(dto.getDataReserva());
		reserva.setDataSaida(dto.getDataSaida());
		
		reserva.setQuarto(quartoRepository.findById(dto.getQuartoId()).orElse(null));

		var colecaoDeHospedes = dto.getHospedesDTO().stream()
										   .map(this.hospedeConverter::dtoParaEntidade)
										   .collect(Collectors.toList());
		
		reserva.getHospedes().addAll(colecaoDeHospedes);
		
		return reserva;
	}

	public Reserva dtoCriarParaEntidade(ReservaCriarDTO dto) {
		
		var reserva = new Reserva();
		
		reserva.setQuarto(quartoRepository.findById(dto.getQuartoId()).orElse(null));
		
		return reserva;
	}
	
}
