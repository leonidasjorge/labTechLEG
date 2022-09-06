package br.com.tiacademy.hotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Hospedagem;
import br.com.tiacademy.hotelaria.dto.HospedagemDTO;

@RestController
@RequestMapping("/hospedagem")
public class HospedagemController extends CrudController<Hospedagem, HospedagemDTO, Integer> {

}
