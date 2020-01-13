package com.cognizant.moviecruiser.dao;

import java.text.SimpleDateFormat;
import java.util.ArrayList;

import com.cognizant.moviecruiser.model.Movies;
import com.cognizant.moviecruiser.util.DateUtil;

public class MoviesDaoSqlImplTest {

	public static void testGetMoviesListAdmin() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListAdmin();

		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		String active;
		String hasteaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				hasteaser = "Yes";
			} else {
				hasteaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasteaser);
			System.out.println();
		}
	}

	public static void testGetMoviesListCustomer() {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		ArrayList<Movies> moviesList = new MoviesDaoSqlImpl().getMoviesListCustomer();

		System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", "ID", "TITLE", "GROSS", "ACTIVE", "DATE_OF_LAUNCH",
				"GENRE", "HAS_TEASER");
		System.out.println();
		String active;
		String hasteaser;
		for (Movies movies : moviesList) {
			if (movies.getActive() == true) {
				active = "Yes";
			} else {
				active = "No";
			}
			if (movies.getTeaser() == true) {
				hasteaser = "Yes";
			} else {
				hasteaser = "No";
			}
			System.out.format("%-10s%-20s%-15s%-10s%-20s%-20s%-10s", movies.getId(), movies.getTitle(),
					movies.getGross(), active, sdf.format(movies.getDateOfLaunch()), movies.getGenre(), hasteaser);
			System.out.println();
		}

	}

	public static void testModifyMovies() {
		Movies menuItem = new Movies(5l, "Avengers: End Game", 1598472630l, false,
				new DateUtil().convertToDate("02/11/2022"), "Superhero", true);

		MoviesDaoSqlImpl menuItemDaoSqlImpl = new MoviesDaoSqlImpl();

		menuItemDaoSqlImpl.modifyMovies(menuItem);

		testGetMoviesListAdmin();

	}

	public static void main(String[] args) {
		testGetMoviesListAdmin();
		testGetMoviesListCustomer();
		testModifyMovies();

	}

}
