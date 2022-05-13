package com.demo.manage.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import java.time.LocalDateTime;

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

