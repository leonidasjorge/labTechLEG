package br.com.tiacademy.hotelaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import br.com.tiacademy.hotelaria.core.crud.CrudDomain;
import br.com.tiacademy.hotelaria.emun.StatusQuarto;
import br.com.tiacademy.hotelaria.emun.TipoQuarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Quarto implements CrudDomain<Integer>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Enumerated(EnumType.STRING)
	private StatusQuarto status;
	
	@Enumerated(EnumType.STRING)
	private TipoQuarto tipo;
	
	@Column(name = "valor_diaria")
	private Double valorDiaria;
	
}
