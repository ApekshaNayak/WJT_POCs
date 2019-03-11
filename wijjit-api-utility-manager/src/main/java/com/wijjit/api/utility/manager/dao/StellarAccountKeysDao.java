package com.wijjit.api.utility.manager.dao;

import com.wijjit.api.utility.manager.models.WijjitStellarAccountKeys;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.time.Instant;
import java.util.Map;

@Repository
public class StellarAccountKeysDao {

    private MongoTemplate mongoTemplate;

    public StellarAccountKeysDao(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public Boolean updateCollection(Map<String, String> acctKeyValuePairs) {
        Query query = new Query();
        query.addCriteria(Criteria.where("label").is("WJT_STELLAR_KEYS"));

        Update update = new Update();
        acctKeyValuePairs.forEach((k,v)-> {
            update.set(k, v);
        });

        update.set("created", Instant.now());
        return mongoTemplate.upsert(query, update, WijjitStellarAccountKeys.class).wasAcknowledged();
    }
}
