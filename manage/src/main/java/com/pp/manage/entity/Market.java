package com.pp.manage.entity;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pp.manage.enums.MarketStatus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection="manage-data")
public class Market {

    @Id
    @Builder.Default
    private String marketID=UUID.randomUUID().toString();
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String marketName;
    private String center;
    private Float radius;
    private Float latitude;
    private Float longitude;
    private String timeZone;
    private String slug;
    private String description;
    private String photo;
    @Indexed
    private String marketState;
    private MarketStatus marketStatus;
    private LocalDateTime deletedAt;
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
    private String marketLocation;
    private Iris irisInfo;
    private Parkeon parkingInfo;
    private List<Venue> venueInfo;

}
