package br.com.tiacademy.hotelaria.core.crud;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public abstract class CrudService<T, ID> {
	
	@Autowired
	protected CrudRepository<T, ID> repository;
	
	public Page<T> paginada(Pageable pageable) {
		return repository.findAll(pageable);
	}
	
	public List<T> listarTodos() {
		return repository.findAll();
	}
	
	public T porId(ID id) {
		return repository.findById(id).orElse(null);
	}

	public T criar(T entidade) {
		return repository.save(entidade);
	}
	
	public void deletar(ID id) {
		repository.deleteById(id);
	}
	
	public T editar(ID id, T entidade) {
		var buscarId = porId(id);
		
		if (Objects.isNull(buscarId)) {
			throw new RuntimeException("Não foi encontrada.");
		}
		
		var salvar = editarEntidade(buscarId, entidade);
		
		return repository.save(salvar);
	}

	protected abstract T editarEntidade(T buscarId, T entidade);
}
