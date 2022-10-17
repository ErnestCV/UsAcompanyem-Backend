package org.hackathon.grup3.app.repository;

import org.hackathon.grup3.app.model.DistricteBarri;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DistricteRepository extends MongoRepository<DistricteBarri, String> {
}
