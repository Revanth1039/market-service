package com.demo.manage.entity;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

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

}
