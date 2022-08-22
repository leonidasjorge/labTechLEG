package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospedeDTO implements Serializable {

	private String cpf;

	private LocalDate data_nascimento;
	private String nome;
	private String sobrenome;
	private String telefone;
}
