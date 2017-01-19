package com.shoppingcart.control;

import java.util.ArrayList;
import java.util.List;

import com.shoppingcart.model.Product;

public enum PricingRules {

	ULT_SMALL_RULE {
		@Override
		protected final double getPrice(final List<Product> items) {
			final List<Product> itemsCopy = new ArrayList<Product>(items);
			double result = 0d;
			final List<Product> ultSmallList = new ArrayList<>();
			for (final Product product : itemsCopy) {
				if (Product.ULT_SMALL.equals(product)) {
					ultSmallList.add(product);
				}
			}
			result += (ultSmallList.size() / 3 * (Product.ULT_SMALL.getPrice() * 2))
					+ (ultSmallList.size() % 3 * Product.ULT_SMALL.getPrice());
			return result;
		}

		@Override
		protected final void addBundle(final List<Product> items) {
			// no nothing
		}
	},
	ULT_LARGE_RULE {
		private static final double BULK_PRICE = 39.90;

		@Override
		protected final double getPrice(final List<Product> items) {
			final List<Product> itemsCopy = new ArrayList<>(items);
			double result = 0d;
			final List<Product> ultLargeList = new ArrayList<>();
			for (final Product product : itemsCopy) {
				if (Product.ULT_LARGE.equals(product)) {
					ultLargeList.add(product);
				}
			}
			if (ultLargeList.size() > 3) {
				result = ultLargeList.size() * BULK_PRICE;
			} else {
				result = ultLargeList.size() * Product.ULT_LARGE.getPrice();
			}
			return result;
		}

		@Override
		protected final void addBundle(final List<Product> items) {
			// do nothing
		}
	},
	ULT_MEDIUM_RULE {
		@Override
		protected final double getPrice(final List<Product> items) {
			final List<Product> itemsCopy = new ArrayList<>(items);
			double result = 0d;

			final List<Product> ultMediumList = new ArrayList<>();
			for (final Product product : itemsCopy) {
				if (Product.ULT_MEDIUM.equals(product)) {
					ultMediumList.add(product);
				}
			}
			result = ultMediumList.size() * Product.ULT_MEDIUM.getPrice();

			return result;
		}

		@Override
		protected final void addBundle(final List<Product> items) {
			final List<Product> itemsCopy = new ArrayList<>(items);
			for (final Product product : itemsCopy) {
				if (Product.ULT_MEDIUM.equals(product)) {
					items.add(Product.ONE_GB);
				}
			}
		}
	},
	ONE_GB_RULE {
		@Override
		protected final double getPrice(List<Product> items) {
			final List<Product> itemsCopy = new ArrayList<>(items);
			double result = 0d;

			final List<Product> ultMediumList = new ArrayList<>();
			for (final Product product : itemsCopy) {
				if (Product.ULT_MEDIUM.equals(product)) {
					ultMediumList.add(product);
				}
			}

			final List<Product> oneGbList = new ArrayList<>();
			for (final Product product : itemsCopy) {
				if (Product.ONE_GB.equals(product)) {
					oneGbList.add(product);
				}
			}
			result = (oneGbList.size() - ultMediumList.size())
					* Product.ONE_GB.getPrice();

			return result;
		}

		@Override
		protected final void addBundle(List<Product> items) {
			// do nothing
		}
	};
	protected abstract double getPrice(final List<Product> items);

	protected abstract void addBundle(final List<Product> items);
}
