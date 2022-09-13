package br.com.tiacademy.hotelaria.controller;

import java.net.Authenticator.RequestorType;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.com.tiacademy.hotelaria.core.crud.CrudController;
import br.com.tiacademy.hotelaria.domain.Quarto;
import br.com.tiacademy.hotelaria.dto.QuartoDTO;
import br.com.tiacademy.hotelaria.repository.QuartoRepository;

@RestController
@RequestMapping("/quarto")
public class QuartoController extends CrudController<Quarto, QuartoDTO, Integer> {

	@Autowired
	protected QuartoRepository repository;
	
	@GetMapping(path = "/valor/{diaria}")
	public ResponseEntity<List<Quarto>> buscarValor(@PathVariable Double diaria) {
		
		List<Quarto> listaDeQuartos = repository.findAllByValorDiaria(diaria);
		
		return ResponseEntity.ok(listaDeQuartos);
	}
	@RequestMapping(value = "/listar", method = RequestMethod.GET)
	public ModelAndView getQuarto() {
		ModelAndView mv = new ModelAndView("quarto/formQuarto");
		List<Quarto> quarto = repository.findAll();
		mv.addObject("formQuarto", quarto);
		return mv;
	}
}
