package com.pp.manage.dto;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.pp.manage.enums.MarketStatus;

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
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Builder.Default
    private LocalDateTime createdAt=LocalDateTime.now();
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Builder.Default
    private LocalDateTime updatedAt=LocalDateTime.now();
    private String center;
    private Float radius;
    private Float latitude;
    private Float longitude;
    private String timeZone;
    private String slug;
    private String description;
    private String photo;
    private String marketState;
    @JsonSerialize(using = LocalDateTimeSerializer.class)
    @Builder.Default
    private LocalDateTime deletedAt=LocalDateTime.now();
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
    @Builder.Default
    private MarketStatus marketStatus=MarketStatus.ACTIVE;
    private String marketLocation;
    private IrisDto irisInfo;
    private ParkeonDto parkingInfo;
    private List<VenueDto> venueInfo;

}
