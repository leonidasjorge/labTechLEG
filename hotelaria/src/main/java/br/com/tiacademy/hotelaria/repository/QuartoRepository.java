package br.com.tiacademy.hotelaria.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.Quarto;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Integer> {
	
	// Query Spring Data
	List<Quarto> findAllByValorDiaria(Double valorDiaria);
	
}
