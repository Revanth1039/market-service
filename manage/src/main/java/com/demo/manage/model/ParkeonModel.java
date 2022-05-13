package com.demo.manage.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ParkeonModel {

    private Long parkeonID;
    private String username;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private LocalDateTime deletedAt;
    private Long marketID;
}

