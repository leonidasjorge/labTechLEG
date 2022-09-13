package br.com.tiacademy.hotelaria.service;

import java.time.LocalDate;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.tiacademy.hotelaria.core.crud.CrudService;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.HospedeReservaDTO;
import br.com.tiacademy.hotelaria.dto.ReservaCriarDTO;
import br.com.tiacademy.hotelaria.emun.StatusQuarto;
import br.com.tiacademy.hotelaria.emun.TipoHospede;
import br.com.tiacademy.hotelaria.emun.TipoQuarto;
import br.com.tiacademy.hotelaria.exception.UnsuportedException;
import br.com.tiacademy.hotelaria.repository.HospedeRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class ReservaService extends CrudService<Reserva, Integer> {

	private final HospedeRepository hospedeRepository;

	public Reserva criarReserva(Reserva reserva, ReservaCriarDTO dto) {

		var ids = dto.getHospedesDTO().stream().map(HospedeReservaDTO::getId).collect(Collectors.toList());

		var hospedes = hospedeRepository.findByIdIn(ids);

		LocalDate dataEntrada = dto.getDataEntrada();
		LocalDate dataSaida = dto.getDataSaida();
		
		Integer qtdHospedesDTO = dto.getHospedesDTO().size();
		
		if (reserva.getQuarto().getStatus().equals(StatusQuarto.OCUPADO)) {
			throw new UnsuportedException("Este quarto está ocupado. Não é possível reservá-lo no momento.");
		}

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.SOLTEIRO) && (qtdHospedesDTO != 1)) {
			throw new UnsuportedException("Não é possível cadastrar mais hóspedes para o quarto do tipo SOLTEIRO. "
					+ "O quarto SOLTEIRO só pode ter 1 hóspede.");
		}

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.CASAL) && ((qtdHospedesDTO <= 0) || (qtdHospedesDTO > 2))) {
			throw new UnsuportedException("Não é possível cadastrar mais hóspedes para o quarto do tipo CASAL. "
					+ "O quarto CASAL só pode ter até 2 hóspedes.");
		}

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.FAMILIAR)
				&& ((qtdHospedesDTO <= 0) || (qtdHospedesDTO > 4))) {
			throw new UnsuportedException("Não é possível cadastrar mais hóspedes para o quarto do tipo FAMILIAR. "
					+ "O quarto FAMILIAR só pode ter até 4 hóspedes.");
		}

		reserva.setDataEntrada(dataEntrada);

		reserva.getQuarto().setStatus(StatusQuarto.OCUPADO);

		reserva.setDataReserva(LocalDate.now());
		reserva.setDataSaida(dataSaida);
		reserva.getHospedes().addAll(hospedes);

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.SOLTEIRO)) {
			reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
		}

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.CASAL)) {
			if (qtdHospedesDTO == 2) {
				reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
				reserva.getHospedes().get(1).setTipoHospede(TipoHospede.DEPENDENTE);
			} else {
				reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
			}

		}

		if (reserva.getQuarto().getTipo().equals(TipoQuarto.FAMILIAR)) {
			
			switch(qtdHospedesDTO) {
				case 4:
					reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
					reserva.getHospedes().get(1).setTipoHospede(TipoHospede.DEPENDENTE);
					reserva.getHospedes().get(2).setTipoHospede(TipoHospede.DEPENDENTE);
					reserva.getHospedes().get(3).setTipoHospede(TipoHospede.DEPENDENTE);
				break;
				case 3:
					reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
					reserva.getHospedes().get(1).setTipoHospede(TipoHospede.DEPENDENTE);
					reserva.getHospedes().get(2).setTipoHospede(TipoHospede.DEPENDENTE);
				break;
				case 2:
					reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
					reserva.getHospedes().get(1).setTipoHospede(TipoHospede.DEPENDENTE);
				break;
				case 1:
					reserva.getHospedes().get(0).setTipoHospede(TipoHospede.TITULAR);
				break;

			}
		}	
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
