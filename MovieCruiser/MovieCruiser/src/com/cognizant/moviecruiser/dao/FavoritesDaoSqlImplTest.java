package com.cognizant.moviecruiser.dao;

import java.util.ArrayList;
import java.util.List;

import com.cognizant.moviecruiser.model.Favorites;
import com.cognizant.moviecruiser.model.Movies;

public class FavoritesDaoSqlImplTest {

	public static void testaddFavoritesMovie() throws FavoritesEmptyException {
		long userId = 2l;
		new FavoritesDaoSqlImpl().addFavoritesMovie(userId, 4);
		testGetFavoritesMovies();
	}

	public static void testGetFavoritesMovies() throws FavoritesEmptyException {

		List<Movies> list = new ArrayList<>();
		long userId = 2l;
		FavoritesDaoSqlImpl cartDaoSqlImpl = new FavoritesDaoSqlImpl();
		Favorites favorites = cartDaoSqlImpl.getAllFavoritesMovies(userId);
		list = favorites.getMoviesList();

		System.out.format("%-10s%-20s%-15s%-15s", "ID", "TITLE", "BOX OFFICE", "GENRE");
		System.out.println();

		for (Movies movies : list) {

			System.out.format("%-10s%-20s%-15s%-15s", movies.getId(), movies.getTitle(), movies.getGross(),
					movies.getGenre());
			System.out.println();
		}
		System.out.println("\nNumber of favorites : " + favorites.getTotal());
	}

	public static void testremoveFavoritesMovie() throws FavoritesEmptyException {
		long userId = 2l;
		new FavoritesDaoSqlImpl().removeFavoritesMovie(userId, 4);
		testGetFavoritesMovies();
	}

	public static void main(String[] args) throws FavoritesEmptyException {
		testaddFavoritesMovie();
		//testGetFavoritesMovies();
		// testremoveFavoritesMovie();

	}

}
