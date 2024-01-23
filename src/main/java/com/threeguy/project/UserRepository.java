package com.threeguy.project;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
    //和数据库交流
    User findByUsername(String username);
}
