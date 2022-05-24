package com.pp.manage.enums;


public enum MarketStatus{
	ACTIVE,ARCHIVED;
	public static MarketStatus convert(String source) {
        return MarketStatus.valueOf(source.toUpperCase());
    }
}

