package com.demo.manage.dto;


import java.time.Instant;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.InstantSerializer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class IrisDto {

	@Builder.Default
    private String irisID= UUID.randomUUID().toString();
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
    private String marketID;
    @JsonSerialize(using = InstantSerializer.class)
    private Instant deletedAt;

}
