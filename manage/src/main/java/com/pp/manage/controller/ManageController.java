package com.pp.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pp.manage.dto.MarketDto;
import com.pp.manage.enums.MarketStatus;
import com.pp.manage.exception.MarketExceptionMessage;
import com.pp.manage.service.ManageService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/market")
@Slf4j
@CrossOrigin(origins="http://localhost:3000")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @PostMapping("/addMarket")
    public MarketDto addMarket(@AuthenticationPrincipal Jwt principal ,@RequestBody MarketDto marketDto) throws MarketExceptionMessage{
    	log.info("inside post api of market"+principal);
        return manageService.addMarketInRepository(marketDto);
    }

    @GetMapping("/getMarketById/{id}")
    public MarketDto getMarketInfo(@AuthenticationPrincipal Jwt principal ,@PathVariable String id) throws MarketExceptionMessage{
    	log.info("inside get market api based on id");
        return manageService.getMarketById(id);
    }


    @PutMapping("/updateMarket/{id}")
    public MarketDto updateMarket(@AuthenticationPrincipal Jwt principal ,@RequestBody MarketDto marketDto,@PathVariable String id) throws MarketExceptionMessage{
    	log.info("inside put api of market");
    	marketDto.setMarketID(id);
        return manageService.updateMarketInRepository(marketDto,id);

    }
    @DeleteMapping("/removeMarketByName/{name}")
    public MarketDto deleteMarket(@AuthenticationPrincipal Jwt principal ,@PathVariable String name) throws MarketExceptionMessage{
    	log.info("inside delete api of market");
        return manageService.removeMarketById(name);
    }

    @GetMapping("/getAllMarketsByStatus/{status}/{pageNo}")
    public List<MarketDto> getAllMaketsbyStatus(@AuthenticationPrincipal Jwt principal ,@PathVariable("status") String status, @PathVariable("pageNo") Integer pageNo){
    	log.info("inside get all market based on status active/archive");
    	MarketStatus marketStatus=MarketStatus.convert(status);
        return manageService.findAllMarketsByStatus(marketStatus,pageNo);
    }
    
    @PostMapping("/addMarketInMQ")
    public String sendDataToMQ(@AuthenticationPrincipal Jwt principal ,@RequestBody MarketDto marketDto){
    	log.info("inside rabbit mq message publisher api");
        return manageService.sendDataToMQ(marketDto);
    }
    
    @PutMapping("/updateMarketStatus/{id}")
    public MarketDto updateMarketStatus(@AuthenticationPrincipal Jwt principal ,@PathVariable String id) throws MarketExceptionMessage {
    	return manageService.updateMarketStatus(id);
    }

    


}
