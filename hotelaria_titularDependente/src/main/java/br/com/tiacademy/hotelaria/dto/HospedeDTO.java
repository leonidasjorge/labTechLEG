package br.com.tiacademy.hotelaria.dto;

import java.io.Serializable;
import java.time.LocalDate;

import br.com.tiacademy.hotelaria.emun.TipoHospede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HospedeDTO implements Serializable {

	private Integer id;
	
	private String cpf;

	private LocalDate dataNascimento;
	
	private String nome;
	private String sobrenome;
	private String telefone;
	
	//private TipoHospede tipoHospede;
}
