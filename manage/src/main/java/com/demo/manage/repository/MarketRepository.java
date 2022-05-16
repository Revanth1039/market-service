package com.demo.manage.repository;

import com.demo.manage.entity.Market;
import com.demo.manage.enums.MarketStatus;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarketRepository extends MongoRepository<Market,String> {

    void deleteByMarketName(String name);


    Page<Market> findAllByMarketStateOrderByMarketName(String state, Pageable paging);

    boolean existsByMarketName(String name);


	Market getByMarketID(String id);


	Market getByMarketName(String name);





	Page<Market> findAllByMarketStatusOrderByMarketName(MarketStatus status, Pageable paging);

}
