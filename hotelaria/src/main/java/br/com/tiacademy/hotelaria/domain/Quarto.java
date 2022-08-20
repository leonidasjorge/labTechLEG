package br.com.tiacademy.hotelaria.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Quarto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private Character tipo;
	private Double valor_diaria;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id", referencedColumnName = "id")
	private Reserva reserva;
	
	@OneToOne
	@JoinColumn(name = "hospedagem_id", referencedColumnName = "id")
	private Hospedagem hospedagem;
	
}
