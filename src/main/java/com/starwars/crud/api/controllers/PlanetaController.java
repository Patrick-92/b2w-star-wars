package com.starwars.crud.api.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.starwars.crud.api.documents.Planeta;
import com.starwars.crud.api.responses.Response;
import com.starwars.crud.api.services.PlanetaService;

@RestController
@RequestMapping(path = "/api/planetas")
public class PlanetaController {
	
	@Autowired
	private PlanetaService planetaService;
	
	@GetMapping
	public ResponseEntity<Response<List<Planeta>>> listarTodos() {
		return ResponseEntity.ok(new Response<List<Planeta>>(this.planetaService.listarTodos()));
	}
	
	@GetMapping(path = "/id/{id}")
	public ResponseEntity<Response<Planeta>> listarPorId (@PathVariable(name = "id") String id) {
		for (Planeta planeta : this.planetaService.listarTodos()) {
			if (planeta.getId().equals(id)) {
				System.out.println(planeta.getNome());
			}
		}

		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.listarPorId(id)));
	}
	
	@GetMapping(path = "/nome/{nome}")
	public ResponseEntity<Response<Planeta>> listarPorNome (@PathVariable(name = "nome") String nome) { 
		for (Planeta planeta : this.planetaService.listarTodos()) {
			if (planeta.getNome().equals(nome)) {
				return ResponseEntity.ok(new Response<Planeta>(this.planetaService.listarPorId(planeta.getId())));
			}
		}
		return null;
	}
	
	@PostMapping
	public ResponseEntity<Response<Planeta>> cadastrar(@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		} if (this.planetaService.cadastrar(planeta) == null) {
			List<String> erros = new ArrayList<String>();
			erros.add("Características do planeta não existem no universo Star Wars!");
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.cadastrar(planeta)));
	}
	
	@PutMapping(path = "/id/{id}")
	public ResponseEntity<Response<Planeta>> atualizar(@PathVariable(name = "id") String id,@Valid @RequestBody Planeta planeta, BindingResult result) {
		if (result.hasErrors()) {
			List<String> erros = new ArrayList<String>();
			result.getAllErrors().forEach(erro -> erros.add(erro.getDefaultMessage()));
			return ResponseEntity.badRequest().body(new Response<Planeta>(erros));
		}
		planeta.setId(id);
		return ResponseEntity.ok(new Response<Planeta>(this.planetaService.atualizar(planeta)));
	}
	
	@DeleteMapping(path = "/id/{id}")
	public ResponseEntity<Response<Integer>> remover(@PathVariable(name = "id") String id){
		this.planetaService.remover(id);
		return ResponseEntity.ok(new Response<Integer>(1));
	}
	
}
