package com.pp.manage.dto;

import java.time.LocalDateTime;
import java.util.UUID;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

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
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Builder.Default
	private LocalDateTime createdAt=LocalDateTime.now();
	@Builder.Default
	private LocalDateTime updatedAt=LocalDateTime.now();
	private String photo;
}
