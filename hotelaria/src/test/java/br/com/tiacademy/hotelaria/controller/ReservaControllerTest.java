package br.com.tiacademy.hotelaria.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservaControllerTest {
	
	@Autowired
	MockMvc mocMvc;
	
	@Test
	public void reservaTestGetAll() throws Exception{
		mocMvc.perform(get("/reserva"))
				.andExpect(status().isOk());
	}
	
	@Test
	public void ReservaTestCriar() throws Exception{
		mocMvc.perform(post("/reserva")
				.contentType("application/json"))
				.andExpectAll(status().isBadRequest());
	}

}
