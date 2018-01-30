package br.com.falasehhrio.server.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import br.com.falasehhrio.server.mongodb.model.Occurrence;

@RepositoryRestResource(collectionResourceRel = "occurrence", path = "occurrence")
public interface OccurrenceRepository extends MongoRepository<Occurrence, String> {
	
}
