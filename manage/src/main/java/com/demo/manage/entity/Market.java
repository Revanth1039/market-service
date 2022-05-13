package com.demo.manage.entity;

import java.net.URL;
import java.time.LocalDateTime;




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
    private Long marketID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String marketName;
    private String center;
    private Long radius;
    private Float latitude;
    private Float longitude;
    private String timeZone;
    private String slug;
    private String description;
    private URL photo;
    private String marketState;
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

}
