package br.com.tiacademy.hotelaria.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import br.com.tiacademy.hotelaria.core.crud.CrudDomain;
import br.com.tiacademy.hotelaria.emun.TipoHospede;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
@Table(name = "hospede_reserva")
public class HospedeReserva implements CrudDomain<Integer>, Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "hospede_id", referencedColumnName = "id")
	private Hospede hospede;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id", referencedColumnName = "id")
	private Reserva reserva;
	
	@Column(name = "tipo_hospede")
	@Enumerated(EnumType.STRING)
	@NotBlank
	private TipoHospede tipoHospede;

	@Override
	public Integer getId() {
		return null;
	}
	
}
