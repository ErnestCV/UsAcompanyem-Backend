package org.hackathon.grup3.app.repository;

import org.hackathon.grup3.app.model.Barrio;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DataRepository extends MongoRepository <Barrio, String> {

}
