package com.shoppingcart.model;

public enum Product {
	ULT_SMALL("ult_small", "Unlimited 1GB", 24.90),
	ULT_MEDIUM("ult_medium", "Unlimited 2GB", 29.90),
	ULT_LARGE("ult_large", "Unlimited 5GB", 44.90),
	ONE_GB("1gb", "1 GB Data-pack", 9.90);	

	private final String code;
	private final String name;
	private final double price;
	
	Product(final String code, final String name, final double price) {
		this.code = code;
		this.name = name;
		this.price = price;
	}
	
	public final String getCode() {
		return code;
	}

	public final String getName() {
		return name;
	}

	public final double getPrice() {
		return price;
	}
}
