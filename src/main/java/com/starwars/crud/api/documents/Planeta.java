package com.starwars.crud.api.documents;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Planeta {
	
	@Id
	private String id;
	private String nome;
	private String clima;
	private String terreno;
	private String aparicoes;
	
	public Planeta(){
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	//@javax.validation.constraints.NotEmpty
	@NotEmpty(message = "Nome não pode ser vazio")
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	//@javax.validation.constraints.NotEmpty
	@NotEmpty(message = "Clima não pode ser vazio")
	public String getClima() {
		return clima;
	}

	public void setClima(String clima) {
		this.clima = clima;
	}

	//@javax.validation.constraints.NotEmpty
	@NotEmpty(message = "Terreno não pode ser vazio")
	public String getTerreno() {
		return terreno;
	}

	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}

	//@javax.validation.constraints.NotEmpty
	public String getAparicoes() {
		return aparicoes;
	}

	public void setAparicoes(String aparicoes) {
		this.aparicoes = aparicoes;
	}
}
