package br.com.tiacademy.hotelaria.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.Reserva;

@Repository
public interface ReservaRepository extends CrudRepository<Reserva, Integer>{

}
