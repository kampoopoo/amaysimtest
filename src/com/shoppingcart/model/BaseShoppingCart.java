package com.shoppingcart.model;

import java.util.List;

public interface BaseShoppingCart {

	void add(final Product item);

	void add(final Product item, final String promoCode);

	double total();

	List<Product> items();
}
