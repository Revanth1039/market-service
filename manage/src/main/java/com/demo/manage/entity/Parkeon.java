package com.demo.manage.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.*;
import java.time.LocalDateTime;


@Builder
@Document(collection="manage-data")
@Data
@Entity
@Table( name = "parkeon" )
@AllArgsConstructor
@NoArgsConstructor
public class Parkeon {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column(name = "id", nullable = false)
    private Long parkeonID;
    @Column(updatable = false)
    @CreationTimestamp
    private LocalDateTime created_at;
    @UpdateTimestamp
    private LocalDateTime updated_at;
    private String username;
    private String encrypted_password;
    private String encrypted_password_iv;
    private LocalDateTime deleted_at;
    @Column(name = "market_id", nullable = false)
    private Long marketID;
}

