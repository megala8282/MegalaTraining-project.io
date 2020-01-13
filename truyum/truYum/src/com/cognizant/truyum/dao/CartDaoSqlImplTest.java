package com.cognizant.truyum.dao;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import com.cognizant.truyum.model.Cart;
import com.cognizant.truyum.model.MenuItem;

public class CartDaoSqlImplTest {

	public static void testAddCartItem() throws CartEmptyException {
		long userId = 2l;
		new CartDaoSqlImpl().addCartItem(userId, 2);
		testGetCartItems();

	}

	public static void testGetCartItems() throws CartEmptyException {

		List<MenuItem> list = new ArrayList<>();
		long userId = 1l;
		CartDaoSqlImpl cartDaoSqlImpl = new CartDaoSqlImpl();
		Cart cart = cartDaoSqlImpl.getAllCartItems(userId);
		list = cart.getMenuItemList();

		DecimalFormat df = new DecimalFormat("#.00");
		System.out.format("%-10s%-20s%-15s%-15s", "ID", "NAME", "FREE_DELIVERY", "PRICE");
		System.out.println();

		String freeDelivery;
		for (MenuItem menuItem : list) {

			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-15s%-15s", menuItem.getId(), menuItem.getName(), freeDelivery,
					df.format(menuItem.getPrice()));
			System.out.println();
		}
		System.out.println("\nTotal Price :" + cart.getTotal());
	}

	public static void testremoveCartItem() throws CartEmptyException {
		long userId = 1l;
		new CartDaoSqlImpl().removeCartItem(userId, 3);
		testGetCartItems();
	}

	public static void main(String[] args) throws CartEmptyException {
		testAddCartItem();
		testGetCartItems();
		testremoveCartItem();
	}

}
