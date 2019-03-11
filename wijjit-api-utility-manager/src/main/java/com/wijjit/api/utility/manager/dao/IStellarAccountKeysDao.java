package com.wijjit.api.utility.manager.dao;

import com.wijjit.api.utility.manager.models.WijjitStellarAccountKeys;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IStellarAccountKeysDao extends MongoRepository<WijjitStellarAccountKeys, String> {

}
