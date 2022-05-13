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
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;
    private String username;
    private String encryptedPassword;
    private String encryptedPasswordIv;
    private LocalDateTime deletedAt;
    @Column(name = "market_id", nullable = false)
    private Long marketID;
}

