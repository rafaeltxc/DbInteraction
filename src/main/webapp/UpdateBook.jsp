<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/book.svg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/newBook.css">
    <title>Home</title>
</head>
<body>
    <main>
        <a href="User/${nickname}" class="return">
            <img src="${pageContext.request.contextPath}/resources/images/leftArrow.png" alt="Arrow">
            <p>Return</p>
        </a>
        <div class="titleHeader">
            <h1>New Book</h1>
        </div>
        <form action="UpdateBook" method="post">
            <fieldset class="title">
                <label for="title">Title</label>
                <input name="title" type="text" value="${title}">
            </fieldset>
            <fieldset class="resume">
                <label for="resume">Resume</label>
                <textarea name="resume" id="resume" cols="30" rows="10">${resume}</textarea>
            </fieldset>
            <fieldset class="book">
                <label for="book">Write your book</label>
                <textarea name="book" id="book" cols="30" rows="10">${book}</textarea>
            </fieldset>
            <input type="submit" class="btn" value="Update Book"/>
        </form>
    </main>
</body>