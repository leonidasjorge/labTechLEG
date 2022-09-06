package br.com.tiacademy.hotelaria.core.crud;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public abstract class ReadController<T extends CrudDomain<ID>, D, ID> {

	@Autowired
	protected CrudService<T, ID> service;

	@Autowired
	protected CrudConverter<T, D> converter;

	@GetMapping
	public ResponseEntity<Page<D>> paginada(Pageable pageable) {
		
		var listaPaginada = service.paginada(pageable).map(converter::entidadeParaDto);
		
		return ResponseEntity.ok(listaPaginada);
	}
	
	@GetMapping("/lista")
	public ResponseEntity<List<D>> listarTodos() {

		var listaDto = service.listarTodos().stream()
				.map(converter::entidadeParaDto)
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(listaDto);
	}

	@GetMapping("/{id}")
	public ResponseEntity<D> listarPorId(@PathVariable("id") ID id) {
		
		var listarEntidadePorId = service.porId(id);
		
		if (Objects.isNull(listarEntidadePorId)) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(converter.entidadeParaDto(listarEntidadePorId));
	}
	
}
