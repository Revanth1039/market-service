package com.demo.manage.dto;


import java.time.LocalDateTime;
import java.util.UUID;

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
    private Long marketID;
    private LocalDateTime deletedAt;

}
