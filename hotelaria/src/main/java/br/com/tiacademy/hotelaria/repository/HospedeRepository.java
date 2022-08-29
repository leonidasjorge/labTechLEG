package br.com.tiacademy.hotelaria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.Hospede;

@Repository
public interface HospedeRepository extends CrudRepository<Hospede, Integer>{
	
	// Query HQL
	@Query("select h from Hospede h where h.id in (:ids)")
	List<Hospede> recuperarHospedePorIds(@Param("ids") List<Integer> ids);

	// Query Nativa que trás o mesmo resultado igual a Query HQL acima
	@Query(nativeQuery = true, value = "select * from hospede where id in (:ids)")
	List<Hospede> recuperarHospedePorIdsNativa(@Param("") List<Integer> ids);
	
	// Query com Spring Data
	List<Hospede> findByIdIn(List<Integer> ids);
	
	// Query com Spring Data
	Hospede findByNome(String nome);
	
	// Query Nativa
	@Query(value = "select * from hospede order by nome", nativeQuery = true)
	List<Hospede> findByAllSortByNome();
	
}
