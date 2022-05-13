package com.demo.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection="manage-data")
public class Market {

    @Id
    @Builder.Default
    private String marketName="None";
    private String marketState;
    private String marketLongitude;
    private String marketLatitude;
    private String mapZoom;
    private String iosMapZoom;
    private String androidMapZoom;
    private String description;


}
