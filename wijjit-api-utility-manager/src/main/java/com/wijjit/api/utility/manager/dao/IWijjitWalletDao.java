package com.wijjit.api.utility.manager.dao;

import com.wijjit.api.utility.manager.models.UserWallets;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IWijjitWalletDao extends MongoRepository<UserWallets, String> {

    @Query("{'uid': ?0 }")
    UserWallets findByUid(String uid);


    @Query("{'userName': ?0 }")
    UserWallets findByUserName(String userName);
}
