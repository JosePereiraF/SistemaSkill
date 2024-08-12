package com.application.sistemaSkill.enums;

public enum NivelENUM {
	BASICO("Basico"),
	INTERMEDIARIO("Intermediario"),
	AVANCADO("Avançado");
	private String nivel;
	NivelENUM(String nivel){
		this.nivel = nivel;
	}
	
	public String getNivel() {
		return nivel;
	}
	public void setNivel(String nivel) {
		this.nivel = nivel;
	}
	
}
