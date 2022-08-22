package br.com.tiacademy.hotelaria.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
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
public class Hospede {
	
	@Id
	private String cpf;

	private LocalDate data_nascimento;
	private String nome;
	private String sobrenome;
	private String telefone;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id", referencedColumnName = "id")
	private Reserva reserva;
	
}
