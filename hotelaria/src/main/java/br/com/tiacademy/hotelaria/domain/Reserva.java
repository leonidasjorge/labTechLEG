package br.com.tiacademy.hotelaria.domain;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Entity
@NoArgsConstructor
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private LocalDate data_reserva;
	private LocalDate data_entrada;
	private LocalDate data_saida;
	
	@Transient
	private Double sub_total;
	
	@ManyToOne
	@JoinColumn(name = "cliente_cpf", referencedColumnName = "cpf")
	private Cliente cliente;
	
	@OneToOne
	@JoinColumn(name = "quarto_id", referencedColumnName = "id")
	private Quarto quarto;
	
	@OneToMany(mappedBy = "reserva")
	private List<Hospede> hospedes;

}
