package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;

import br.com.tiacademy.hotelaria.emun.TipoHospede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospedeReservaDTO implements Serializable {

	private HospedeDTO hospede;
	private ReservaDTO reserva;
	
	private Integer hospedeId;
	private Integer reservaId;
	
	private TipoHospede tipoHospede;
	
}