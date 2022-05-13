package com.demo.manage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class ParkeonModel {

    private Long parkeonID;
    private String username;
    private String encrypted_password;
    private String encrypted_password_iv;
    private LocalDateTime deleted_at;
    private Long marketID;
}

