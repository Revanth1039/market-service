package com.pp.manage.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pp.manage.dto.MarketDto;
import com.pp.manage.enums.MarketStatus;
import com.pp.manage.exception.MarketExceptionMessage;

@Service
public interface ManageService {

	public MarketDto addMarketInRepository(MarketDto marketDto) throws MarketExceptionMessage;

	public MarketDto getMarketById(String id) throws MarketExceptionMessage;

	public MarketDto updateMarketInRepository(MarketDto marketDto, String id) throws MarketExceptionMessage;

	public MarketDto removeMarketById(String name) throws MarketExceptionMessage;

	public List<MarketDto> findAllMarketsByStatus(MarketStatus status, Integer pageNo);

	public String sendDataToMQ(MarketDto marketDto);

	public MarketDto updateMarketStatus(String id) throws MarketExceptionMessage;

}
