package br.com.tiacademy.hotelaria.domain;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import br.com.tiacademy.hotelaria.core.crud.CrudDomain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reserva implements CrudDomain<Integer>, Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "data_entrada")
	private LocalDate dataEntrada;	
	
	@Column(name = "data_reserva")
	private LocalDate dataReserva;
	
	@Column(name = "data_saida")
	private LocalDate dataSaida;
	
	@OneToOne
	@JoinColumn(name = "quarto_id", referencedColumnName = "id")
	private Quarto quarto;	
	
	@OneToMany(mappedBy = "reserva", cascade = CascadeType.ALL)
	private Collection<HospedeReserva> hospedeReservaList;

	public Double getSubTotal() {
		
		var valorMultiplicador = dataEntrada.until(dataSaida, ChronoUnit.DAYS) + 1L;
		
		return quarto.getValorDiaria() * valorMultiplicador;
	}
	
}
