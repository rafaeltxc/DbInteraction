<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
	<link rel="icon" href="${pageContext.request.contextPath}/resources/images/book.svg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/user.css" /> 
    <title>Library</title>
</head>
<body>
    <main>
        <div class="header">
            <a href="/Library/Logout" class="return">
                <img src="${pageContext.request.contextPath}/resources/images/leftArrow.png" alt="Arrow">
                <p>Log Out</p>
            </a>
            <a href="/Library/User/${nickname}" class="titleHeader">
                <h1> ${nickname}'s Library</h1>
                <img src="${pageContext.request.contextPath}/resources/images/book.svg" alt="Book">
            </a>
            <div class="inf">
                <div class="search">
                	<form action="/Library/User/Search?search=${search}" method="get">
                    	<img src="${pageContext.request.contextPath}/resources/images/search.svg" alt="search">
                    	<input type="search" name="search" placeholder="Which book are you looking for?">
                   	</form>
                </div>
                <a href="/Library/NewBook" class="newBook">
                    <p>New Book</p>
                    <img src="${pageContext.request.contextPath}/resources/images/plus.svg" alt="Plus sign">
                </a>
            </div>
        </div>
        <div class="container">
            <h2>All Books</h2>
            <c:forEach items="${list}" var="t">
	            <a href="/Library/Book/${t.idBook}" class="book">
	                <p class="title">${t.title}</p>
	                <p class="text">${t.resume}</p>
	            </a>
            </c:forEach>
        </div>
    </main>
</body>
</html>