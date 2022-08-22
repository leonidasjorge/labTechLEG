package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class ReservaDTO implements Serializable {

	private Integer id;
	
	private LocalDate data_reserva;
	private LocalDate data_entrada;
	private LocalDate data_saida;
	
	@Transient
	private Double sub_total;
	
}
