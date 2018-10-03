package com.starwars.crud.api.services;

import java.util.List;
import java.util.Optional;

import com.starwars.crud.api.documents.Planeta;

public interface PlanetaService {
	
	List<Planeta> listarTodos();
	
	Optional<Planeta> listarPorId(String id);
	
	Optional<Planeta> listarPorNome(String id);
	
	Planeta cadastrar(Planeta planeta);
	
	Planeta atualizar(Planeta planeta);
	
	void remover(String id);
}
