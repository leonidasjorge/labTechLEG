package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import br.com.tiacademy.hotelaria.emun.Tipo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class QuartoDTO implements Serializable {

	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private Tipo tipo;
	
	private Double valor_diaria;
	
}
