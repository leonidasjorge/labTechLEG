package br.com.tiacademy.hotelaria.domain;

import java.util.Date;

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
	
	private Date data_reserva;
	private Date data_entrada;
	private Date data_saida;
	private Double sub_total;
	
	@ManyToOne
	@JoinColumn(name = "hospede_cpf", referencedColumnName = "cpf")
	private Hospede hospede;
	
}
