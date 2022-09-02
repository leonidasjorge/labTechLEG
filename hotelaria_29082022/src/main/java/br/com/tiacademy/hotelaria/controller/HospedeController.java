package br.com.tiacademy.hotelaria.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Hospede;
import br.com.tiacademy.hotelaria.dto.HospedeDTO;
import br.com.tiacademy.hotelaria.repository.HospedeRepository;

@RestController
@RequestMapping("/hospede")
public class HospedeController extends CrudController<Hospede, HospedeDTO, Integer> {

	@Autowired
	public HospedeRepository repository;

	@GetMapping("/nome/{nome}")
	public Hospede listarNome(@PathVariable String nome) {
		return repository.findByNome(nome);
	}
	
	@GetMapping("/ordenar")
	public ResponseEntity<List<Hospede>> ordenar() {
		List<Hospede> ordemNome = repository.findByAllSortByNome();
		return ResponseEntity.ok(ordemNome);
	}

}
