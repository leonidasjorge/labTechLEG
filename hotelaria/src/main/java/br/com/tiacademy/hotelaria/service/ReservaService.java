package br.com.tiacademy.hotelaria.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.HospedeReservaDTO;
import br.com.tiacademy.hotelaria.dto.ReservaCriarDTO;
import br.com.tiacademy.hotelaria.repository.HospedeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReservaService extends CrudService<Reserva, Integer> {

	private final HospedeRepository hospedeRepository;
	
	public Reserva criarReserva(Reserva reserva, ReservaCriarDTO dto) {
		
		var ids = dto.getHospedesDTO().stream()
								   .map(HospedeReservaDTO::getId)
								   .collect(Collectors.toList());
		
		var hospedes = hospedeRepository.findByIdIn(ids);
		
		LocalDate dataEntrada = dto.getDataEntrada();
		LocalDate dataSaida = dto.getDataSaida();
		
		reserva.setDataEntrada(dataEntrada);
		reserva.setDataReserva(LocalDate.now());
		reserva.setDataSaida(dataSaida);
		reserva.getHospedes().addAll(hospedes);
		
		return super.criar(reserva);
	}
	
	@Override
	protected Reserva editarEntidade(Reserva buscarId, Reserva entidade) {
		
		buscarId.setId(entidade.getId());
		buscarId.setDataEntrada(entidade.getDataEntrada());		
		buscarId.setDataReserva(entidade.getDataReserva());
		buscarId.setDataSaida(entidade.getDataSaida());
		buscarId.setQuarto(entidade.getQuarto());

		buscarId.getHospedes().clear();
		buscarId.getHospedes().addAll(entidade.getHospedes());
		
		return buscarId;
	}

}
