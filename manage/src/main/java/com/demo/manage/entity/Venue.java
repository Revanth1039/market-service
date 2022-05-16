package com.demo.manage.entity;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Document(collection="manage-data")
public class Venue {
	
	@Id
    @Builder.Default
    private String venueID=UUID.randomUUID().toString();
	
	private String title;
	private Instant createdAt;
	private String updatedAt;
	private String photo;
	

}
