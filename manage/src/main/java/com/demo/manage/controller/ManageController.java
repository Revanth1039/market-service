package com.demo.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.manage.model.MarketModel;
import com.demo.manage.service.ManageService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/market")
@Slf4j
public class ManageController {

    @Autowired
    private ManageService manageService;

    @PostMapping("/addMarket")
    public MarketModel addMarket(@RequestBody MarketModel marketModel){
        return manageService.addMarketToRepository(marketModel);
    }

    @GetMapping("/getMarketByName/{name}")
    public MarketModel getMarketInfo(@PathVariable String name){
        log.info(name);
        return manageService.getMarketById(name);
    }


    @PutMapping("/updateMarket")
    public MarketModel updateMarket(MarketModel marketModel){
        return manageService.updateMarketInRepository(marketModel);

    }
    @DeleteMapping("/removeMarketByName/{name}")
    public MarketModel deleteMarket(@PathVariable String name){
        return manageService.removeMarketById(name);
    }

    @GetMapping("/getAllMarketsByState/{state}/{pageNo}")
    public List<MarketModel> getAllMaketsbyState(@PathVariable String state, @PathVariable Integer pageNo){
        return manageService.findAllMarketsByState(state,pageNo);
    }
    
    @PostMapping("/addMarketInMQ")
    public String sendDataToMQ(@RequestBody MarketModel marketModel){
        return manageService.sendDataToMQ(marketModel);
    }

    


}
