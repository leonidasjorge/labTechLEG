package br.com.tiacademy.hotelaria.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Cliente;

@RestController
@RequestMapping("/cliente")
public class ClienteController extends CrudController<Cliente, Integer>{

}
