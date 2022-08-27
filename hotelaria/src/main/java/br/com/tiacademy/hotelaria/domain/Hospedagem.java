package br.com.tiacademy.hotelaria.domain;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.tiacademy.hotelaria.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Hospedagem implements CrudDomain<Integer>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "check_in")
	private LocalDate checkIn;
	
	@Column(name = "check_out")
	private LocalDate checkOut;
	
	@ManyToOne
	@JoinColumn(name = "reserva_id", referencedColumnName = "id")
	private Reserva reserva;
	
}
