package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;

import br.com.tiacademy.hotelaria.emun.StatusQuarto;
import br.com.tiacademy.hotelaria.emun.TipoQuarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class QuartoDTO implements Serializable {

	private Integer id;

	private StatusQuarto status;
	
	private TipoQuarto tipo;
	
	private Double valorDiaria;
	
}
