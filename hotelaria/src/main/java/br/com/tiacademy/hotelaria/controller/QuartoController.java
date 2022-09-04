package br.com.tiacademy.hotelaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Quarto;
import br.com.tiacademy.hotelaria.dto.QuartoDTO;
import br.com.tiacademy.hotelaria.repository.QuartoRepository;

@RestController
@RequestMapping("/quarto")
public class QuartoController extends CrudController<Quarto, QuartoDTO, Integer> {

	@Autowired
	protected QuartoRepository repository;
	
	@GetMapping(path = "/valor/{diaria}")
	public ResponseEntity<List<Quarto>> buscarValor(@PathVariable Double diaria) {
		
		List<Quarto> listaDeQuartos = repository.findAllByValorDiaria(diaria);
		
		return ResponseEntity.ok(listaDeQuartos);
	}
}
