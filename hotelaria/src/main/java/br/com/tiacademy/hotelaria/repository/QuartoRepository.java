package br.com.tiacademy.hotelaria.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.Quarto;

@Repository
public interface QuartoRepository extends CrudRepository<Quarto, Integer> {

	// Query com HQL
	@Query(value = "select q from Quarto q where q.valor_diaria = ?1")
	Quarto consultaDiaria(Double diaria);
}
