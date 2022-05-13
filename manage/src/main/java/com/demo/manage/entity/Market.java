package com.demo.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.net.URL;
import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection="manage-data")
public class Market {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    private Long marketID;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;
    private String name;
    private String center;
    private Long radius;
    private Float latitude;
    private Float longitude;
    private String time_zone;
    private String slug;
    private String description;
    private URL photo;
    private String state;
    private LocalDateTime deleted_at;
    private Integer map_zoom;
    private Integer android_map_zoom;
    private Integer ios_map_zoom;
    private Integer reservation_max_duration_days;
    private Integer house_account_reservation_max_duration_days;
    private String time_zone_abbreviation;
    private Boolean top_market;
    private Integer active_locations_count;
    private Integer competitor_locations_count;
    private Boolean visible;
    private String default_home_screen;

}
