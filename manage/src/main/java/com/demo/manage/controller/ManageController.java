package com.demo.manage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.manage.controller.exception.MarketExceptionMessage;
import com.demo.manage.dto.MarketDto;
import com.demo.manage.enums.MarketStatus;
import com.demo.manage.service.ManageService;

import lombok.extern.slf4j.Slf4j;


@RestController
@RequestMapping("/market")
@Slf4j
@CrossOrigin(origins="http://localhost:3000")
public class ManageController {

    @Autowired
    private ManageService manageService;

    @PostMapping("/addMarket")
    public MarketDto addMarket(@RequestBody MarketDto marketDto) throws MarketExceptionMessage{
    	log.info("inside post api of market");
        return manageService.addMarketToRepository(marketDto);
    }

    @GetMapping("/getMarketById/{id}")
    public MarketDto getMarketInfo(@PathVariable String id) throws MarketExceptionMessage{
    	log.info("inside get market api based on id");
        return manageService.getMarketById(id);
    }


    @PutMapping("/updateMarket/{id}")
    public MarketDto updateMarket(@RequestBody MarketDto marketDto,@PathVariable String id) throws MarketExceptionMessage{
    	log.info("inside put api of market");
    	marketDto.setMarketID(id);
        return manageService.updateMarketInRepository(marketDto,id);

    }
    @DeleteMapping("/removeMarketByName/{name}")
    public MarketDto deleteMarket(@PathVariable String name) throws MarketExceptionMessage{
    	log.info("inside delete api of market");
        return manageService.removeMarketById(name);
    }

    @GetMapping("/getAllMarketsByStatus/{status}/{pageNo}")
    public List<MarketDto> getAllMaketsbyState(@PathVariable("status") String status, @PathVariable("pageNo") Integer pageNo){
    	log.info("inside get all market based on status active/archive");
    	MarketStatus marketStatus=MarketStatus.convert(status);
        return manageService.findAllMarketsByState(marketStatus,pageNo);
    }
    
    @PostMapping("/addMarketInMQ")
    public String sendDataToMQ(@RequestBody MarketDto marketDto){
    	log.info("inside rabbit mq message publisher api");
        return manageService.sendDataToMQ(marketDto);
    }

    


}
