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
public class IrisModel {

    private Long irisID;
    private String username;
    private String password;
    private String encrypted_password;
    private String encrypted_password_iv;
    private String paystation_token;
    private String encrypted_paystation_token;
    private String encrypted_paystation_token_iv;
    private String plateinfo_token;
    private String encrypted_plateinfo_token;
    private String encrypted_plateinfo_token_iv;
    private String transaction_token;
    private String encrypted_transaction_token;
    private String encrypted_transaction_token_iv;
    private Long marketID;
    private LocalDateTime deleted_at;

}
