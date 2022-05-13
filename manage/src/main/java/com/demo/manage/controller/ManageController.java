package com.demo.manage.controller;

import com.demo.manage.model.MarketModel;
import com.demo.manage.service.ManageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;


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


}
