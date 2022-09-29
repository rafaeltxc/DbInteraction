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
    <link rel="stylesheet" href="./resources/css/signIn.css">
    <title>Sign in</title>
</head>
<body>
    <div class="background"></div>
    <main>
        <div class="misc">
            <img class="rocketImg" src="./resources/images/rocket.svg" alt="Floating rocket">
        </div>
        <div class="signIn">
            <form class="form" action="SignIn" method="post">
                <fieldset>
                    <label for="login">NickName</label>
                    <input name="nickname" type="text" placeholder="nickName">
                </fieldset>
                <fieldset>
                    <label for="login">Password</label>
                    <input name="password" type="password" placeholder="*****">
                </fieldset>
                <a href="#">Forgot password?</a>
                <input type="submit" class="btn" value="SignIn">
                <a href="/Library/SignUp">Don't have an account?</a>
            </form>
        </div>
    </main>
</body>
</html>