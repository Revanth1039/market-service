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

import com.demo.manage.dto.MarketDto;
import com.demo.manage.service.ManageService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/market")
@Slf4j
public class ManageController {

    @Autowired
    private ManageService manageService;

    @PostMapping("/addMarket")
    public MarketDto addMarket(@RequestBody MarketDto marketDto){
        return manageService.addMarketToRepository(marketDto);
    }

    @GetMapping("/getMarketByName/{name}")
    public MarketDto getMarketInfo(@PathVariable String name){
        log.info(name);
        return manageService.getMarketById(name);
    }


    @PutMapping("/updateMarket")
    public MarketDto updateMarket(MarketDto marketDto){
        return manageService.updateMarketInRepository(marketDto);

    }
    @DeleteMapping("/removeMarketByName/{name}")
    public MarketDto deleteMarket(@PathVariable String name){
        return manageService.removeMarketById(name);
    }

    @GetMapping("/getAllMarketsByState/{state}/{pageNo}")
    public List<MarketDto> getAllMaketsbyState(@PathVariable String state, @PathVariable Integer pageNo){
        return manageService.findAllMarketsByState(state,pageNo);
    }
    
    @PostMapping("/addMarketInMQ")
    public String sendDataToMQ(@RequestBody MarketDto marketDto){
        return manageService.sendDataToMQ(marketDto);
    }

    


}
