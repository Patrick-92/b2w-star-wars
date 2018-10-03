package com.starwars.crud.api.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.starwars.crud.api.documents.Planeta;

public interface PlanetaRepository extends MongoRepository<Planeta, String> {

}
