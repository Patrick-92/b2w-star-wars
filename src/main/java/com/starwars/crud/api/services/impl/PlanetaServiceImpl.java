package com.starwars.crud.api.services.impl;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.starwars.crud.api.documents.Planeta;
import com.starwars.crud.api.repositories.PlanetaRepository;
import com.starwars.crud.api.services.PlanetaService;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

@Service
public class PlanetaServiceImpl implements PlanetaService {

	@Autowired
	private PlanetaRepository planetaRepository;
	
	private static final String urlSwapi = "https://swapi.co/api/planets/?search=";
	
	@Override
	public List<Planeta> listarTodos() {
		return this.planetaRepository.findAll();
	}

	@Override
	public Planeta listarPorId(String id) {
		return this.planetaRepository.findOne(id);
	}
	
	@Override
	public Planeta listarPorNome(String nome) {
		return this.planetaRepository.findOne(nome);
	}

	@Override
	public Planeta cadastrar(Planeta planeta) {
		if (this.aparicoes(planeta) != null) {
			Integer qtdAparicoes = this.aparicoes(planeta);
			planeta.setAparicoes(qtdAparicoes.toString());
			return this.planetaRepository.save(planeta);
		} else {
			return null;
		}
	}

	@Override
	public Planeta atualizar(Planeta planeta) {
		return this.planetaRepository.save(planeta);
	}
	
	private Integer aparicoes(Planeta planeta) {
		StringBuilder url = new StringBuilder();
		RestTemplate restTemplate = new RestTemplate();
		Object ObjetoGenerico;
		HttpHeaders headers = new HttpHeaders();
		Gson gson = new Gson();
		JsonElement arrayAparicoes = null;
		
		url.append(urlSwapi).append(planeta.getNome());

		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		headers.add("user-agent",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");

		try {
			ObjetoGenerico = restTemplate.exchange(url.toString(), HttpMethod.GET,
					new HttpEntity<String>("parameters", headers), Object.class);
		} catch (Exception e) {
			return null;
		}

		JsonArray resultado = gson.fromJson(gson.toJson(ObjetoGenerico), JsonObject.class).getAsJsonObject("body")
				.getAsJsonArray("results");

		for (JsonElement e : resultado) {
			if (e.getAsJsonObject().get("name").getAsString().equalsIgnoreCase(planeta.getNome())) {
				arrayAparicoes = e;
			}
		}
		
		if (arrayAparicoes == null) {
			return null;
		} else {
			String climaRequ[] = planeta.getClima().split(Pattern.quote(","));
			Arrays.sort(climaRequ);
			climaRequ = Arrays.stream(climaRequ).map(String::trim).toArray(String[]::new);
			String climaSwapi[] = arrayAparicoes.getAsJsonObject().get("climate").getAsString().split(Pattern.quote(","));
			Arrays.sort(climaSwapi);
			climaSwapi = Arrays.stream(climaSwapi).map(String::trim).toArray(String[]::new);
			if (!Arrays.equals(climaRequ, climaSwapi)) {
				return null;
			}
			
			String terrenoRequ[] = planeta.getTerreno().split(Pattern.quote(","));
			Arrays.sort(terrenoRequ);
			terrenoRequ = Arrays.stream(terrenoRequ).map(String::trim).toArray(String[]::new);
			String terrenoSwapi[] = arrayAparicoes.getAsJsonObject().get("terrain").getAsString().split(Pattern.quote(","));
			Arrays.sort(terrenoSwapi);
			terrenoSwapi = Arrays.stream(terrenoSwapi).map(String::trim).toArray(String[]::new);
			if (!Arrays.equals(terrenoRequ, terrenoSwapi)) {
				System.out.println(terrenoRequ[1].toString());
				return null;
			}
			return arrayAparicoes.getAsJsonObject().getAsJsonArray("films").size();
		}
	}

	@Override
	public void remover(String id) {
		this.planetaRepository.delete(id);
	}

}
