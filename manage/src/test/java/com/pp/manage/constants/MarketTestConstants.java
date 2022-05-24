package com.pp.manage.constants;

import java.time.LocalDateTime;
import java.util.UUID;

import com.pp.manage.enums.MarketStatus;



public class MarketTestConstants {
	
	    public static final String MARKET_ID=UUID.randomUUID().toString();
	    public static final String MARKET_NAME="MARKET-TEST";
	    public static final LocalDateTime CREATED_AT=LocalDateTime.now();
	    public static final LocalDateTime UPDATED_AT=LocalDateTime.now();
	    public static final String CENTER="TEST CENTER";
	    public static final Float RADIUS= new Float(2.0);
	    public static final Float LATTITUDE=new Float(2.0);
	    public static final Float LONGITUDE=new Float(2.0);
	    public static final String TIMEZONE="utc";
	    public static final String SLUG="TEST SLUG";
	    public static final String DESCRIPTION="na";
	    public static final String MARKET_STATE="sydney";
	    public static final LocalDateTime DELETED_AT=LocalDateTime.now();
	    public static final MarketStatus MARKET_STATUS=MarketStatus.ACTIVE;
//	    public static final Integer mapZoom;
//	    public static final Integer androidMapZoom;
//	    public static final Integer iosMapZoom;
//	    public static final Integer reservationMaxDurationDays;
//	    public static final Integer houseAccountReservationMaxDurationDays;
//	    public static final String timeZoneAbbreviation;
//	    public static final Boolean topMarket;
//	    public static final Integer activeLocationsCount;
//	    public static final Integer competitorLocationsCount;
//	    public static final Boolean visible;
//	    public static final String defaultHomeScreen;
//	    public static final String photo;
//	    public static final String marketLocation;
//	    public static final IrisDto irisInfo;
//	    public static final ParkeonDto parkingInfo;
//	    public static final List<VenueDto> venueInfo;


}
