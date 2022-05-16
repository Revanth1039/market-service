package com.demo.manage.dto;

import java.time.Instant;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VenueDto {


	@Builder.Default
	private String venueID=UUID.randomUUID().toString();
	
	private String title;
	private Instant createdAt;
	private String updatedAt;
	private String photo;
}
