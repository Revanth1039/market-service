package com.demo.manage.repository;

import com.demo.manage.entity.Market;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends MongoRepository<Market,Long> {

    void deleteByMarketName(String name);


    Page<Market> findAllByMarketStateOrderByMarketName(String state, Pageable paging);

    boolean existsByMarketName(String name);


	Market getByMarketID(Long id);


	Market getByMarketName(String name);

}
