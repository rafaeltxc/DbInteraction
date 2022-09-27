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
    <link rel="stylesheet" href="./resources/css/newBook.css">
    <title>Home</title>
</head>
<body>
    <main>
        <a href="./Library.jsp" class="return">
            <img src="./resources/images/leftArrow.png" alt="Arrow">
            <p>Return</p>
        </a>
        <div class="titleHeader">
            <h1>New Book</h1>
        </div>
        <form action="NewBook" method="post">
            <fieldset class="title">
                <label for="title">Title</label>
                <input name="title" type="text">
            </fieldset>
            <fieldset class="resume">
                <label for="resume">Resume</label>
                <textarea name="resume" id="resume" cols="30" rows="10"></textarea>
            </fieldset>
            <fieldset class="book">
                <label for="book">Write your book</label>
                <textarea name="book" id="book" cols="30" rows="10"></textarea>
            </fieldset>
            <input type="submit" class="btn" value="Add Book"/>
        </form>
    </main>
</body>