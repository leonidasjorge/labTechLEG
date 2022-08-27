package br.com.tiacademy.hotelaria.core.crud;

public interface CrudConverter<T, D> {

	D entidadeParaDto(T entidade);
	
	T dtoParaEntidade(D dto);
	
}
