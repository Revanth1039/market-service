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
public class ParkeonDto {

	@Builder.Default
	private String parkeonID=UUID.randomUUID().toString();
	private String username;
	private String encryptedPassword;
	private String encryptedPasswordIv;
	private LocalDateTime deletedAt;
	private Long marketID;
}
