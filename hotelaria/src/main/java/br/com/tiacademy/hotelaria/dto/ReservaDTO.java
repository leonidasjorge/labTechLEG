package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ReservaDTO implements Serializable {

	private Integer id;
	
	private LocalDate dataReserva;
	private LocalDate dataEntrada;
	private LocalDate dataSaida;
	
	private QuartoDTO quarto;
	
	private Integer quartoId;
	
	private List<HospedeDTO> hospedesDTO = new ArrayList<>();

}
