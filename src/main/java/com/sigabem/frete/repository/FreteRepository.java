package com.sigabem.frete.repository;

import com.sigabem.frete.model.Frete;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreteRepository extends MongoRepository<Frete, String> {
}
