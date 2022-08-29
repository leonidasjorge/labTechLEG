package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.tiacademy.hotelaria.domain.Quarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReservaCriarDTO implements Serializable {
	
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	private Integer quartoId;
	
	private List<HospedeReservaDTO> hospedesDTO = new ArrayList<>();
	
}
