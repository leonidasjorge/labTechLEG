package br.com.tiacademy.hotelaria.emun;

public enum Tipo {

	CASAL("C"),
	FAMILIAR("F"),
	SOLTEIRO("S");
	
	private String caractere;

	Tipo(String caractere) {
		this.caractere = caractere;
	}
	
	public String getCaractere() {
		return caractere;
	}
}
