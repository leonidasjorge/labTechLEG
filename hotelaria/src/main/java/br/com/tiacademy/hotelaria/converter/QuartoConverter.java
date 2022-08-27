package br.com.tiacademy.hotelaria.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.Quarto;
import br.com.tiacademy.hotelaria.dto.QuartoDTO;

@Component
public class QuartoConverter implements CrudConverter<Quarto, QuartoDTO> {

	@Override
	public QuartoDTO entidadeParaDto(Quarto entidade) {
		
		var dto = new QuartoDTO();
		
		dto.setId(entidade.getId());
		dto.setTipo(entidade.getTipo());
		dto.setValorDiaria(entidade.getValorDiaria());
		
		return dto;
	}

	@Override
	public Quarto dtoParaEntidade(QuartoDTO dto) {

		var quarto = new Quarto();
		
		quarto.setId(dto.getId());
		quarto.setTipo(dto.getTipo());
		quarto.setValorDiaria(dto.getValorDiaria());
		
		return quarto;
		
	}

}
