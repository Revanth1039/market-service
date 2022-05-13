package com.demo.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;




@Builder
@Document(collection="manage-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parkeon {

    @Id
    private Long parkeonID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private LocalDateTime deletedAt;
    private Long marketID;
}

