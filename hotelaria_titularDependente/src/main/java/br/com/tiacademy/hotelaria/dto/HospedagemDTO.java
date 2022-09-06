package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospedagemDTO implements Serializable {

	private Integer id;
	
	private LocalDate checkIn;
	private LocalDate checkOut;
	private Double total;
	
	private Integer reservaId;
	
	private ReservaDTO reservaDTO;
	
}
