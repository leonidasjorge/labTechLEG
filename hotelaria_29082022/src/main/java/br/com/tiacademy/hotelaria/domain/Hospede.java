package br.com.tiacademy.hotelaria.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.tiacademy.hotelaria.core.crud.CrudDomain;
import br.com.tiacademy.hotelaria.emun.TipoHospede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Hospede implements CrudDomain<Integer>, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;	
	
	private String cpf;

	@Column(name = "data_nascimento")
	private LocalDate dataNascimento;

	private String nome;
	private String sobrenome;
	private String telefone;
	
	@Column(name = "tipo_hospede")
	@Enumerated(EnumType.STRING)
	private TipoHospede tipoHospede;
	
}
