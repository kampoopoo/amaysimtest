package shoppingcart;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.shoppingcart.control.PricingRules;
import com.shoppingcart.control.ShoppingCart;
import com.shoppingcart.model.Product;

public class TestShoppingCart {

	@Test
	public void testScenario1() {
		final ShoppingCart sc = new ShoppingCart(PricingRules.ULT_SMALL_RULE);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_LARGE);
		assertEquals(sc.total(), 94.70, 0);
		assertEquals(getCount(sc.items(), Product.ULT_SMALL), 3);
		assertEquals(getCount(sc.items(), Product.ULT_LARGE), 1);
	}

	@Test
	public void testScenario2() {
		final ShoppingCart sc = new ShoppingCart(PricingRules.ULT_SMALL_RULE);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_LARGE);
		sc.add(Product.ULT_LARGE);
		sc.add(Product.ULT_LARGE);
		sc.add(Product.ULT_LARGE);
		assertEquals(sc.total(), 209.40, 0);
		assertEquals(getCount(sc.items(), Product.ULT_SMALL), 2);
		assertEquals(getCount(sc.items(), Product.ULT_LARGE), 4);
	}

	@Test
	public void testScenario3() {
		final ShoppingCart sc = new ShoppingCart(PricingRules.ULT_SMALL_RULE);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ULT_MEDIUM);
		sc.add(Product.ULT_MEDIUM);
		assertEquals(sc.total(), 84.70, 0);
		assertEquals(getCount(sc.items(), Product.ULT_SMALL), 1);
		assertEquals(getCount(sc.items(), Product.ULT_MEDIUM), 2);
		assertEquals(getCount(sc.items(), Product.ONE_GB), 2);
	}

	@Test
	public void testScenario4() {
		final ShoppingCart sc = new ShoppingCart(PricingRules.ULT_SMALL_RULE);
		sc.add(Product.ULT_SMALL);
		sc.add(Product.ONE_GB, "I<3AMAYSIM");
		assertEquals(sc.total(), 31.32, 0);
		assertEquals(getCount(sc.items(), Product.ULT_SMALL), 1);
		assertEquals(getCount(sc.items(), Product.ONE_GB), 1);
	}

	private final int getCount(final List<Product> items, final Product product) {
		int result = 0;
		for (final Product p : items) {
			if (product.equals(p)) {
				result++;
			}
		}
		return result;
	}
}
