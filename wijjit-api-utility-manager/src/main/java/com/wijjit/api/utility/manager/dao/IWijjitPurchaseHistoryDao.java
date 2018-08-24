package com.wijjit.api.utility.manager.dao;

import com.wijjit.api.utility.manager.models.WijjitPurchaseHistory;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IWijjitPurchaseHistoryDao extends MongoRepository<WijjitPurchaseHistory, String> {

    @Query(value = "{'userName': ?0, 'transactionType': ?1}")
    List<WijjitPurchaseHistory> findByUserName(String userName, String transactionType);

    @Query(value = "{'userName': ?0}")
    List<WijjitPurchaseHistory> findByUserName(String userName);
}
