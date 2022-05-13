package com.demo.manage.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Builder
@Document(collection="manage-data")
@Entity
@Table( name = "iris" )
@AllArgsConstructor
@NoArgsConstructor
public class Iris {

    @Id
    @Column(name = "id", nullable = false)
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
    @Column(name = "market_id", nullable = false)
    private Long marketID;
    private LocalDateTime deleted_at;

}
