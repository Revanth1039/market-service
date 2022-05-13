package com.demo.manage.entity;

import java.time.Instant;

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
    private Long parkeonID;
    private Instant createdAt;
    private Instant updatedAt;
    private String username;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private Instant deletedAt;
    private Long marketID;
}

