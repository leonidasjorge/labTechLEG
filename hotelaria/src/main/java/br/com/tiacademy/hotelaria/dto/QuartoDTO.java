package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;

import br.com.tiacademy.hotelaria.emun.Status;
import br.com.tiacademy.hotelaria.emun.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class QuartoDTO implements Serializable {

	private Integer id;

	private Status status;
	
	private Tipo tipo;
	
	private Double valorDiaria;
	
}
