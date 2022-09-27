<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
            <a href="./Home.jsp" class="return">
                <img src="./resources/images/leftArrow.png" alt="Arrow">
                <p>Log Out</p>
            </a>
            <div class="titleHeader">
                <h1>"user's" Library</h1>
                <img src="./resources/images/book.svg" alt="Book">
            </div>
            <div class="inf">
                <div class="search">
                    <img src="./resources/images/search.svg" alt="search">
                    <input type="search" name="search" id="search" placeholder="Which book are you looking for?">
                </div>
                <a href="./NewBook.jsp" class="newBook">
                    <p>New Book</p>
                    <img src="./resources/images/plus.svg" alt="Plus sign">
                </a>
            </div>
        </div>
        <div class="container">
            <h2>All Books</h2>
            <a href="./Book.jsp" class="book">
                <p class="title">Title</p>
                <p class="text">Lorem ipsum dolor sit amet</p>
            </a>
        </div>
    </main>
</body>
</html>