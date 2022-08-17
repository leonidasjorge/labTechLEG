package br.com.tiacademy.hotelaria.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Quarto;
import br.com.tiacademy.hotelaria.repository.QuartoRepository;

@RestController
@RequestMapping("/quarto")
public class QuartoController extends CrudController<Quarto, Integer> {

	@Autowired
	protected QuartoRepository repository;
	
	@GetMapping(path = "/valor/{diaria}")
	public ResponseEntity<Quarto> buscarValor(@PathVariable Double diaria) {
		return ResponseEntity.ok(repository.consultaDiaria(diaria));
	}
	
}
