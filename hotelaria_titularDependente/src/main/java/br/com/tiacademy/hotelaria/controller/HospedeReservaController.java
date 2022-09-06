package br.com.tiacademy.hotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.ReadController;
import br.com.tiacademy.hotelaria.domain.HospedeReserva;
import br.com.tiacademy.hotelaria.dto.HospedeReservaDTO;

@RestController
@RequestMapping("/hospedeReserva")
public class HospedeReservaController extends ReadController<HospedeReserva, HospedeReservaDTO, Integer> {

}
