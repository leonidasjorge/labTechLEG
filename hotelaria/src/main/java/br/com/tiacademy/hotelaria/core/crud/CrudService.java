package br.com.tiacademy.hotelaria.core.crud;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class CrudService<T, ID> {
	
	@Autowired
	protected CrudRepository<T, ID> repository;
	
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
		var salvar = editarEntidade(buscarId, entidade);
		return repository.save(salvar);
	}

	protected abstract T editarEntidade(T buscarId, T entidade);
}
