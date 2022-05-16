package com.demo.manage.dto;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.demo.manage.enums.MarketStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MarketDto {

    @Builder.Default
    private String marketID=UUID.randomUUID().toString();
    private String marketName;
    private Instant createdAt;
    private Instant updatedAt;
    private String center;
    private Float radius;
    private Float latitude;
    private Float longitude;
    private String timeZone;
    private String slug;
    private String description;
    private String photo;
    private String marketState;
    private Instant deletedAt;
    private Integer mapZoom;
    private Integer androidMapZoom;
    private Integer iosMapZoom;
    private Integer reservationMaxDurationDays;
    private Integer houseAccountReservationMaxDurationDays;
    private String timeZoneAbbreviation;
    private Boolean topMarket;
    private Integer activeLocationsCount;
    private Integer competitorLocationsCount;
    private Boolean visible;
    private String defaultHomeScreen;
    private MarketStatus marketStatus;
    private String marketLocation;
    private IrisDto irisInfo;
    private ParkeonDto parkingInfo;
    private List<VenueDto> venueInfo;

}
