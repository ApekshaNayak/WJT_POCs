package com.wijjit.api.utility.manager.dao;

import com.wijjit.api.utility.manager.models.CivicUserData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ICivicUserDataDao extends MongoRepository<CivicUserData, String> {

	@Query("{'civicUserId': ?0 }")
	CivicUserData findByCivicUserId(String civicUserId);
	
	@Query("{'email': ?0 }")
	CivicUserData findByEmail(String email);
	
	@Query("{'userName': ?0 }")
	CivicUserData findByUserName(String userName);
	
	@Query(value = "{'userName': ?0}", fields="{userName:1, isKyc:1, civicUserToken:1, " +
			"civicUserTokenUpdationTimestamp:1, authInfo:1, kycInfo: 1}")
	CivicUserData findByUserNameProjection(String userName);
}
