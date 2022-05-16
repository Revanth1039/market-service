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
public class ParkeonDto {

	@Builder.Default
	private String parkeonID=UUID.randomUUID().toString();
	private String username;
	private String encryptedPassword;
	private String encryptedPasswordIv;
	@JsonSerialize(using = InstantSerializer.class)
	private Instant deletedAt;
	private Long marketID;
}
