package com.pp.manage.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class MarketExceptionMessage extends Throwable{
	public static final long serialVersionUID =123;
	private String Code;
	private String Message;	
	
}