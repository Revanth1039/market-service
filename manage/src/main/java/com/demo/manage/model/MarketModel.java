package com.demo.manage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class MarketModel {

    private String marketName;
    private String marketState;
    private String marketLongitude;
    private String marketLatitude;
    private String mapZoom;
    private String iosMapZoom;
    private String androidMapZoom;
    private String description;
}
