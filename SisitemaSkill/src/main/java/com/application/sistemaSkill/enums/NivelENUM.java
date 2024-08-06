package com.application.sistemaSkill.enums;

public enum NivelENUM {
	BASICO("basico"),
	INTERMEDIARIO("intermediario"),
	AVANCADO("avancado");
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
