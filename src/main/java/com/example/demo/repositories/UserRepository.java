package com.example.demo.repositories;

import com.example.demo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Fernanda on 09/06/2018.
 */
@Repository
public interface UserRepository extends MongoRepository<User, String> {
}
