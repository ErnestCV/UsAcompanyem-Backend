package org.hackathon.grup3.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.hackathon.grup3.app.model.User;
import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {

    Optional<User> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
}
