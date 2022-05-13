package com.demo.manage.service;


import com.demo.manage.entity.Market;
import com.demo.manage.model.MarketModel;
import com.demo.manage.repository.MarketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ManageService {


    private MarketRepository marketRepository;

    public ManageService(final MarketRepository marketRepository) {
        this.marketRepository = marketRepository;
    }

    public MarketModel addMarketToRepository(MarketModel marketModel) {
        Market market=new Market();
        BeanUtils.copyProperties(marketModel,market);
        marketRepository.save(market);
        return marketModel;
    }

    public MarketModel getMarketById(String name) {
        Market market=marketRepository.getByMarketName(name);
        log.info(market.toString());
        MarketModel marketModel=new MarketModel();
        BeanUtils.copyProperties(market,marketModel);
        return marketModel;
    }

    public MarketModel updateMarketInRepository(MarketModel marketModel) {
        Market market=new Market();
        BeanUtils.copyProperties(marketModel,market);
        marketRepository.save(market);
        return marketModel;
    }

    public MarketModel removeMarketById(String name) {
        if(marketRepository.existsById(name)){
            Market market=marketRepository.getByMarketName(name);
            MarketModel marketModel=new MarketModel();
            BeanUtils.copyProperties(market,marketModel);
            marketRepository.deleteByMarketName(name);
            return marketModel;
        }
        return null;
    }

    public List<MarketModel> findAllMarketsByState(String state,Integer pageNo) {
        List<MarketModel> marketModels=new ArrayList<>();
        Pageable paging = PageRequest.of(pageNo,10);
        Page<Market> pagedResult=marketRepository.findAllByMarketStateOrderByMarketName(state,paging);
        pagedResult.toList().stream().forEach((market) -> {
            MarketModel marketModel=new MarketModel();
            BeanUtils.copyProperties(market,marketModel);
            marketModels.add(marketModel);
        });
        return marketModels;

    }
}
