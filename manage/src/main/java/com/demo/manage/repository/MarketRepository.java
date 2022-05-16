package com.demo.manage.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.demo.manage.entity.Market;
import com.demo.manage.enums.MarketStatus;

@Repository
public interface MarketRepository extends MongoRepository<Market,String> {

    void deleteByMarketName(String name);



    boolean existsByMarketName(String name);


	Market getByMarketID(String id);


	Market getByMarketName(String name);





	Page<Market> findAllByMarketStatusOrderByMarketName(MarketStatus status, Pageable paging);

}
