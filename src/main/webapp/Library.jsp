<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="./resources/images/book.svg">
    <link rel="stylesheet" href="./resources/css/reset.css">
    <link rel="stylesheet" href="./resources/css/library.css">
    <title>Home</title>
</head>
<body>
    <main>
        <div class="header">
            <a href="/Home" class="return">
                <img src="./resources/images/leftArrow.png" alt="Arrow">
                <p>Log Out</p>
            </a>
            <div class="titleHeader">
                <h1> ${nickname}'s Library</h1>
                <img src="./resources/images/book.svg" alt="Book">
            </div>
            <div class="inf">
                <div class="search">
                    <img src="./resources/images/search.svg" alt="search">
                    <input type="search" name="search" id="search" placeholder="Which book are you looking for?">
                </div>
                <a href="/Library/NewBook" class="newBook">
                    <p>New Book</p>
                    <img src="./resources/images/plus.svg" alt="Plus sign">
                </a>
            </div>
        </div>
        <div class="container">
            <h2>All Books</h2>
            <c:forEach items="${list}" var="t">
	            <a href="/Book" class="book">
	                <p class="title">${t.title}</p>
	                <p class="text">${t.resume}</p>
	            </a>
            </c:forEach>
        </div>
    </main>
</body>
</html>