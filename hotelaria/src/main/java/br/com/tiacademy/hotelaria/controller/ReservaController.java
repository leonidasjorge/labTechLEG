package br.com.tiacademy.hotelaria.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.tiacademy.hotelaria.converter.ReservaConverter;
import br.com.tiacademy.hotelaria.core.crud.ReadController;
import br.com.tiacademy.hotelaria.domain.Reserva;
import br.com.tiacademy.hotelaria.dto.ReservaCriarDTO;
import br.com.tiacademy.hotelaria.dto.ReservaDTO;
import br.com.tiacademy.hotelaria.service.ReservaService;

@RestController
@RequestMapping("/reserva")
public class ReservaController extends ReadController<Reserva, ReservaDTO, Integer> {
	
	private ReservaConverter getConverter() {
		return (ReservaConverter) converter;
	}
	
	private ReservaService getService() {
		return (ReservaService) service;
	}
	
	@PostMapping
	public ResponseEntity<ReservaDTO> criar(@RequestBody ReservaCriarDTO dto) {
		
		var reserva = getConverter().dtoCriarParaEntidade(dto);
		
		var salvar = getService().criarReserva(reserva, dto);
		
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		
		var uri = builder.path("/{id}").buildAndExpand(salvar.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDto(salvar));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<ReservaDTO> editar(@PathVariable("id") Integer id, @RequestBody ReservaDTO dto) {
		
		var novaEntidade = getConverter().dtoParaEntidade(dto);
		var salvar = getService().editar(id, novaEntidade);
		
		return ResponseEntity.ok(getConverter().entidadeParaDto(salvar));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") Integer id) {
		
		getService().deletar(id);
		return ResponseEntity.noContent().build();
	}	
	
}
