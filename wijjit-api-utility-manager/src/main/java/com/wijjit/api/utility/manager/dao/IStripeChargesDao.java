	package com.wijjit.api.utility.manager.dao;

    import com.wijjit.api.utility.manager.models.StripeChargeResponse;
    import org.springframework.data.mongodb.repository.MongoRepository;
    import org.springframework.data.mongodb.repository.Query;
    import org.springframework.stereotype.Repository;

    import java.util.List;

    @Repository
    public interface IStripeChargesDao extends MongoRepository<StripeChargeResponse, String> {

        @Query(value = "{'userName': ?0}")
        List<StripeChargeResponse> findByUsername(String username);
    }
