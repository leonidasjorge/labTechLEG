package br.com.tiacademy.hotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.ReadController;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.ReservaDTO;

@RestController
@RequestMapping("/reserva")
public class ReservaController extends ReadController<Reserva, ReservaDTO, Integer> {
	
	

}
