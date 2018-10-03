package com.starwars.crud.api.documents;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;
@Document
public class PlanetaSwapi {

		private String nome;
        private String periodoDeRotacao;
        private String PeriodoOrbital;
        private String diametro;
		private String clima;
		private String gravidade;
		private String terreno;
		private String superficieAquatica;
		private String populacao;
		private List<String> residencia;
		private List<String> aparicoes;
		private String criado;
		private String editado;
		private String url;
		
		public PlanetaSwapi(){
			
		}

		public String getNome() {
			return nome;
		}

		public void setNome(String nome) {
			this.nome = nome;
		}

		public String getPeriodoDeRotacao() {
			return periodoDeRotacao;
		}

		public void setPeriodoDeRotacao(String periodoDeRotacao) {
			this.periodoDeRotacao = periodoDeRotacao;
		}

		public String getPeriodoOrbital() {
			return PeriodoOrbital;
		}

		public void setPeriodoOrbital(String periodoOrbital) {
			PeriodoOrbital = periodoOrbital;
		}

		public String getDiametro() {
			return diametro;
		}

		public void setDiametro(String diametro) {
			this.diametro = diametro;
		}

		public String getClima() {
			return clima;
		}

		public void setClima(String clima) {
			this.clima = clima;
		}

		public String getGravidade() {
			return gravidade;
		}

		public void setGravidade(String gravidade) {
			this.gravidade = gravidade;
		}

		public String getTerreno() {
			return terreno;
		}

		public void setTerreno(String terreno) {
			this.terreno = terreno;
		}

		public String getSuperficieAquatica() {
			return superficieAquatica;
		}

		public void setSuperficieAquatica(String superficieAquatica) {
			this.superficieAquatica = superficieAquatica;
		}

		public String getPopulacao() {
			return populacao;
		}

		public void setPopulacao(String populacao) {
			this.populacao = populacao;
		}

		public List<String> getResidencia() {
			return residencia;
		}

		public void setResidencia(List<String> residencia) {
			this.residencia = residencia;
		}

		public List<String> getAparicoes() {
			return aparicoes;
		}

		public void setAparicoes(List<String> aparicoes) {
			this.aparicoes = aparicoes;
		}

		public String getCriado() {
			return criado;
		}

		public void setCriado(String criado) {
			this.criado = criado;
		}

		public String getEditado() {
			return editado;
		}

		public void setEditado(String editado) {
			this.editado = editado;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

}
