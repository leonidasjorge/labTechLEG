package br.com.tiacademy.hotelaria.core.crud;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

public abstract class CrudController<T extends CrudDomain<ID>, D, ID> extends ReadController<T, D, ID> {
	
	@PostMapping
	public ResponseEntity<D> criar(@RequestBody D dto) {
		
		var entidade = converter.dtoParaEntidade(dto);
		var salvar = service.criar(entidade);
		
		ServletUriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
		
		var uri = builder.path("/{id}").buildAndExpand(salvar.getId()).toUri();
		
		return ResponseEntity.created(uri).body(converter.entidadeParaDto(salvar));
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<D> editar(@PathVariable("id") ID id, @RequestBody D dto) {
		
		var novaEntidade = converter.dtoParaEntidade(dto);
		var salvar = service.editar(id, novaEntidade);
		
		return ResponseEntity.ok(converter.entidadeParaDto(salvar));
		
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}	

}
