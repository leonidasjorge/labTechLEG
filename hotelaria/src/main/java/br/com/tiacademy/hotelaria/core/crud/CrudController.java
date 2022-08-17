package br.com.tiacademy.hotelaria.core.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public abstract class CrudController<T, ID> {

	@Autowired
	protected CrudService<T, ID> service;

	@GetMapping
	public ResponseEntity<List<T>> listarTodos() {
		var listar = service.listarTodos();
		return ResponseEntity.ok(listar);
	}

	@GetMapping("/{id}")
	public ResponseEntity<T> listarPorId(@PathVariable("id") ID id) {
		var listarId = service.porId(id);
		return ResponseEntity.ok(listarId);
	}

	@PostMapping
	public ResponseEntity<T> criar(@RequestBody T entidade) {
		var salvar = service.criar(entidade);
		return ResponseEntity.ok(salvar);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable("id") ID id) {
		service.deletar(id);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<T> editar(@PathVariable("id") ID id, @RequestBody T entidade) {
		var salvar = service.editar(id, entidade);
		return ResponseEntity.ok(salvar);
	}

}
