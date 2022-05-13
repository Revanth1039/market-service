package com.demo.manage.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Builder
@Document(collection="manage-data")
@AllArgsConstructor
@NoArgsConstructor
public class Iris {

    @Id
    private Long irisID;
    private String username;
    private String password;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private String paystationToken;
    private String encryptedPaystationToken;
    private String encryptedPaystationTokenIv;
    private String plateinfoToken;
    private String encryptedPlateinfoToken;
    private String encryptedPlateinfoTokenIv;
    private String transactionToken;
    private String encryptedTransactionToken;
    private String encryptedTransactionTokenIv;
    private Long marketID;
    private LocalDateTime deletedAt;

}
