<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="icon" href="${pageContext.request.contextPath}/resources/images/book.svg">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/reset.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/book.css">
    <title>Book</title>
</head>
<body>
    <main>
        <a href="/Library/User/${nickname}" class="return">
            <img src="${pageContext.request.contextPath}/resources/images/leftArrow.png" alt="Arrow">
            <p>Return</p>          
        </a>
        <h1>${title}</h1>
        <div class="book">
        	${text}
        </div>
        <div class="btnsDiv">
        	<a href="/Library/UpdateBook/${idBook}" class="btn" type="button">Update</a>
        	<a href="/Library/deleteBook?id=${idBook}" class="btn" type="button" >Delete</a>
        </div>
    </main>
</body>
</html>