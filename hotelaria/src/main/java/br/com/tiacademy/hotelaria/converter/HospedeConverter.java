package br.com.tiacademy.hotelaria.converter;

import org.springframework.stereotype.Component;

import br.com.tiacademy.hotelaria.core.crud.CrudConverter;
import br.com.tiacademy.hotelaria.domain.Hospede;
import br.com.tiacademy.hotelaria.dto.HospedeDTO;

@Component
public class HospedeConverter implements CrudConverter<Hospede, HospedeDTO>{

	@Override
	public HospedeDTO entidadeParaDto(Hospede entidade) {
		
		var dto = new HospedeDTO();
		
		dto.setId(entidade.getId());
		dto.setCpf(entidade.getCpf());
		dto.setDataNascimento(entidade.getDataNascimento());
		dto.setNome(entidade.getNome());
		dto.setSobrenome(entidade.getSobrenome());
		dto.setTelefone(entidade.getTelefone());
		dto.setTipoHospede(entidade.getTipoHospede());
		
		return dto;
	}

	@Override
	public Hospede dtoParaEntidade(HospedeDTO dto) {

		var hospede = new Hospede();
		
		hospede.setId(dto.getId());
		hospede.setCpf(dto.getCpf());
		hospede.setDataNascimento(dto.getDataNascimento());
		hospede.setNome(dto.getNome());
		hospede.setSobrenome(dto.getSobrenome());
		hospede.setTelefone(dto.getTelefone());
		hospede.setTipoHospede(dto.getTipoHospede());
		
		return hospede;
		
	}

}
