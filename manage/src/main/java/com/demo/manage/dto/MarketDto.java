package com.demo.manage.dto;
import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.demo.manage.enums.MarketStatus;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

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
    @JsonSerialize(using = InstantSerializer.class)
    private Instant createdAt;
    @JsonSerialize(using = InstantSerializer.class)
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
    @JsonSerialize(using = InstantSerializer.class)
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
    @Builder.Default
    private MarketStatus marketStatus=MarketStatus.ACTIVE;
    private String marketLocation;
    private IrisDto irisInfo;
    private ParkeonDto parkingInfo;
    private List<VenueDto> venueInfo;

}
