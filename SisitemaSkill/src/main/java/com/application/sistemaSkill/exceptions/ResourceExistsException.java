package com.application.sistemaSkill.exceptions;

public class ResourceExistsException extends  RuntimeException{
    private static final long serialVersionUID = 1L;
    public ResourceExistsException(String mensagem){
    	super(mensagem);
    }
}
