package br.com.tiacademy.hotelaria.domain;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Cliente {
	
	@Id
	private Integer cpf;
	
	private LocalDate data_nascimento;
	private String nome;
	private String sobrenome;
	private String telefone;
	
}
