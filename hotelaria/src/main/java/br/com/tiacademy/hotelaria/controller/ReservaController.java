package br.com.tiacademy.hotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.repository.ReservaRepository;

@RestController
@RequestMapping("/reserva")
public class ReservaController extends CrudController<Reserva, Integer> {
	
	@Autowired
	protected ReservaRepository repository;

}
