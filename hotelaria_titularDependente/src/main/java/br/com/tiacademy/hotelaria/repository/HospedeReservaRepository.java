package br.com.tiacademy.hotelaria.repository;

import org.springframework.stereotype.Repository;

import br.com.tiacademy.hotelaria.core.crud.CrudRepository;
import br.com.tiacademy.hotelaria.domain.HospedeReserva;

@Repository
public interface HospedeReservaRepository extends CrudRepository<HospedeReserva, Integer> {

}
