package com.demo.manage.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;




@Builder
@Document(collection="manage-data")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Parkeon {

    @Id
    private String parkeonID;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String username;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private LocalDateTime deletedAt;
    private Long marketID;
}

