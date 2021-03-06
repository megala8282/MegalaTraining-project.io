<%@ page language="java" isELIgnored="false"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<link rel="stylesheet" href="styles/style.css">
<!-- <script src="script.js"></script>-->
<title>Edit Movies</title>
</head>
<body>
	<div class="topnav">
		<div class="home">Movie Cruiser</div>
		<img src="images/movie-logo-dark.png"> <a href="ShowFavorites">Favorites</a>
		<a href="ShowMoviesListCustomer">Movies</a>
	</div>
	<div class="page-title"></div>
	<div class="content">
		<h1>Movies</h1>
		<c:if test="${addFavoritesStatus}">
		<div class="success-message">Movie added to Favorites
			Successfully.</div>
	</c:if>
		<table>
			<tr>
				<th>Title</th>
				<th>Box Office</th>
				<th>Genre</th>
				<th>Has Teaser</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${moviesList}" var="movies">
				<tr>
					<td>${movies.title}</td>
					<td>$<fmt:formatNumber type="number" value="${movies.gross}" /></td>
					<td>${movies.genre}</td>
					<td><c:choose>
							<c:when test="${movies.teaser}">Yes</c:when>
							<c:otherwise>No</c:otherwise>
						</c:choose></td>
					<td><a href="AddToFavorites?id=${movies.id}">Add to
							Favorite</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
	<div class="footer">
		<h3>Copyright &#169; 2019</h3>
	</div>

</body>
</html>