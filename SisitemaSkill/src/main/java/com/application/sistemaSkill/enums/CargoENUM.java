package com.application.sistemaSkill.enums;

public enum CargoENUM {
	ROLE_USUARIO("usuario");
	private String cargo;
	CargoENUM(String cargo){
		this.cargo = cargo;
	}
	public String getCargo() {
		return cargo;
	}
	public void setCargo(String cargo) {
		this.cargo = cargo;
	}
	
}
