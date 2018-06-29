package org.exia.atlantis.model;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

/**
 * Created by Azerom on 29/06/2018.
 */
public interface UserRepository extends MongoRepository<ApplicationUser, String> {

    public Optional<ApplicationUser> findById(String id);

}
