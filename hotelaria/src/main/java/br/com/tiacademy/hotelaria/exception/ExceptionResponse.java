package br.com.tiacademy.hotelaria.exception;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ExceptionResponse implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String details;
	private String message;
	private Date timestamp;
	
}
