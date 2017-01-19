package com.shoppingcart.control;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.BaseShoppingCart;
import com.shoppingcart.model.Product;

public final class ShoppingCart implements BaseShoppingCart {
	private static final String PROMO_CODE_10_PCT = "I<3AMAYSIM";
	private final PricingRules pricingRules;
	private final List<Product> items;
	private String promoCode;

	public ShoppingCart(final PricingRules pricingRules) {
		this.pricingRules = pricingRules;
		this.items = new ArrayList<>();
	}

	public final void add(final Product item) {
		add(item, null);
	}

	public final void add(final Product item, final String promoCode) {
		this.promoCode = promoCode;
		items.add(item);
	}

	public final double total() {
		BigDecimal result = BigDecimal.valueOf(0);
		final PricingRules[] pRules = PricingRules.values();
		for (final PricingRules rule : pRules) {
			BigDecimal price = BigDecimal.valueOf(rule.getPrice(items));
			result = result.add(price);
			rule.addBundle(items);
		}
		if (PROMO_CODE_10_PCT.equalsIgnoreCase(promoCode)) {
			final BigDecimal percent = result.multiply(BigDecimal.valueOf(0.1));
			result = result.subtract(percent);
		}
		return result.doubleValue();
	}

	public final List<Product> items() {
		return items;
	}
}
