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
public class ParkeonDto {

	@Builder.Default
	private String parkeonID=UUID.randomUUID().toString();
	private String username;
	private String encryptedPassword;
	private String encryptedPasswordIv;
	@JsonSerialize(using = LocalDateTimeSerializer.class)
	@Builder.Default
	private LocalDateTime deletedAt=LocalDateTime.now();
	private Long marketID;
}
