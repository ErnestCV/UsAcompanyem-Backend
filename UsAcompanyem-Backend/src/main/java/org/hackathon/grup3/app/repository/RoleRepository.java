package org.hackathon.grup3.app.repository;

import org.hackathon.grup3.app.model.ERole;
import org.hackathon.grup3.app.model.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {

    Optional<Role> findByName(ERole name);
}
