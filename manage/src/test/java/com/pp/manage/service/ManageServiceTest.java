package com.pp.manage.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.pp.manage.constants.MarketTestConstants;
import com.pp.manage.dto.MarketDto;
import com.pp.manage.entity.Market;
import com.pp.manage.enums.MarketStatus;
import com.pp.manage.exception.MarketExceptionMessage;
import com.pp.manage.repository.MarketRepository;
import com.pp.manage.serviceImpl.ManageServiceImpl;
@SpringBootTest
public class ManageServiceTest {
	
	@InjectMocks
	private ManageServiceImpl manageService;
	
	@Mock
	private MarketRepository marketRepository;
	
	@Test
	public void getAllMarketByStatusTest() {
		
		List<Market> marketResult=new ArrayList<>();
		Pageable paging = PageRequest.of(0, 10);
		Market market=Market.builder().marketID(MarketTestConstants.MARKET_ID).build();
		marketResult.add(market);
		Page<Market> marketPageData=new PageImpl<Market>(marketResult, paging, marketResult.size());
		when(marketRepository.findAllByMarketStatusOrderByMarketName(MarketStatus.ACTIVE, paging)).thenReturn(marketPageData);
		List<MarketDto> responseData=manageService.findAllMarketsByStatus(MarketStatus.ACTIVE, 0);
		assertEquals(1,responseData.size());
		assertEquals(MarketTestConstants.MARKET_ID,responseData.get(0).getMarketID());
	}
	
	@Test
	public void updateMarketTest() throws MarketExceptionMessage {
		MarketDto marketDto=MarketDto.builder().marketID(MarketTestConstants.MARKET_ID).build();
		when(marketRepository.existsById(MarketTestConstants.MARKET_ID)).thenReturn(true);
		when(marketRepository.getByMarketID(MarketTestConstants.MARKET_ID)).thenReturn(Market.builder().marketID(MarketTestConstants.MARKET_ID).build());
		MarketDto responseDto = manageService.updateMarketInRepository(marketDto, MarketTestConstants.MARKET_ID);
		assertEquals(MarketTestConstants.MARKET_ID,responseDto.getMarketID());
	}
	
	@Test
	public void addMarketTest() throws MarketExceptionMessage {
		when(marketRepository.save(Market.builder().marketID(MarketTestConstants.MARKET_ID).build())).thenReturn(null);
		MarketDto marketDto=MarketDto.builder().marketID(MarketTestConstants.MARKET_ID).build();
		MarketDto responseDto = manageService.addMarketInRepository(marketDto);
		assertEquals(MarketTestConstants.MARKET_ID,responseDto.getMarketID());
	}
	

}
