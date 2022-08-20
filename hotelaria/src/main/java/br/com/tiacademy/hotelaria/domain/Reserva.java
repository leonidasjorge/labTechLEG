package br.com.tiacademy.hotelaria.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate data_reserva;
	private LocalDate data_entrada;
	private LocalDate data_saida;
	
	@ManyToOne
	@JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
	private Cliente cliente;
	
}
