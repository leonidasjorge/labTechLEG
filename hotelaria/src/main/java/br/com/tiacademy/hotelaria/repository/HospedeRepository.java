package br.com.tiacademy.hotelaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.Hospede;

@Repository
public interface HospedeRepository extends CrudRepository<Hospede, Integer>{
	
	// Query com SpringData
	Hospede findByNome(String nome);
	
	// Query Nativa
	@Query(value = "select * from hospede order by nome", nativeQuery = true)
	List<Hospede> findByAllSortByNome();
	
}
