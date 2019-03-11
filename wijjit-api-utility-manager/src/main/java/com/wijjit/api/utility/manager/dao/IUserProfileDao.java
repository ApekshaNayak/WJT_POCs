package com.wijjit.api.utility.manager.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.wijjit.jwt.api.security.model.UserProfile;

@Repository
public interface IUserProfileDao extends MongoRepository<UserProfile, String>{

    @Query(value = "{'referralCode': ?0}")
    UserProfile findByUserId(String userName);
}

