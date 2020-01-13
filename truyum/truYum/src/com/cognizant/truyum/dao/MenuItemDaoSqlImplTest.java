package com.cognizant.truyum.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.truyum.model.MenuItem;
import com.cognizant.truyum.util.DateUtil;

public class MenuItemDaoSqlImplTest {

	public static void testGetMenuItemListAdmin() throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListAdmin();
		System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);
			System.out.println();
		}

	}

	public static void testGetMenuItemListCustomer() throws SQLException {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		DecimalFormat df = new DecimalFormat("#.00");
		ArrayList<MenuItem> menuItemList = new MenuItemDaoSqlImpl().getMenuItemListCustomer();
		System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", "ID", "NAME", "PRICE", "ACTIVE", "DATE_OF_LAUNCH",
				"CATEGORY", "FREE_DELIVERY");
		System.out.println();
		String active;
		String freeDelivery;
		for (MenuItem menuItem : menuItemList) {
			if (menuItem.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (menuItem.getFreeDelivery() == true) {
				freeDelivery = "Yes";
			} else {
				freeDelivery = "No";
			}
			System.out.format("%-10s%-20s%-10s%-10s%-15s%-15s%-10s", menuItem.getId(), menuItem.getName(),
					df.format(menuItem.getPrice()), active, sdf.format(menuItem.getDateOfLaunch()),
					menuItem.getCategory(), freeDelivery);
			System.out.println();
		}

	}

	public static void testModifyMenuItem() throws NumberFormatException, IOException, SQLException {
		MenuItem menuItem = new MenuItem(4l, "Fries", 80.00f, true, new DateUtil().convertToDate("10/10/2022"),
				"Main Course", true);
		MenuItemDaoSqlImpl menuItemDaoSqlImpl = new MenuItemDaoSqlImpl();
		menuItemDaoSqlImpl.modifyMenuItem(menuItem);
		testGetMenuItemListAdmin();

	}

	public static void main(String[] args) throws SQLException, NumberFormatException, IOException {

		testGetMenuItemListAdmin();
		testGetMenuItemListCustomer();
		testModifyMenuItem();
	}

}
