package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospedagemDTO implements Serializable {

	private Integer id;
	
	private LocalDate check_in;
	private LocalDate check_out;
	
	@Transient
	private Double total;
	
}
