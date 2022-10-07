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
		<link rel="stylesheet" href="./resources/css/signUp.css">
		<title>Sign up</title>
	</head>
	<body>
		<div class="background"></div>
		<main>
			<div class="signUp">
				<form class="form" action="SignUp" method="post">
					<fieldset>
						<label for="login">Choose a nickname</label>
						<input name="nickname" type="text" placeholder="Nickname">
					</fieldset>
					<fieldset>
						<label for="login">Choose a password</label>
						<input name="password" type="password" placeholder="*****">
					</fieldset>
					<fieldset>
						<label for="login">Write your password again</label>
						<input type="password" placeholder="*****">
					</fieldset>
					<div class="birth">
						<select name="month" id="month">
							<option value="01">Jan</option>
							<option value="02">Feb</option>
							<option value="03">Mar</option>
							<option value="04">Apr</option>
							<option value="05">May</option>
							<option value="06">Jun</option>
							<option value="07">Jul</option>
							<option value="08">Aug</option>
							<option value="09">Sep</option>
							<option value="10">Oct</option>
							<option value="11">Nov</option>
							<option value="12">Dec</option>
						</select>
						<select name="day" id="day">
							<option value="01">01</option>
							<option value="02">02</option>
							<option value="03">03</option>
							<option value="04">04</option>
							<option value="05">05</option>
							<option value="06">06</option>
							<option value="07">07</option>
							<option value="08">08</option>
							<option value="09">09</option>
							<option value="10">10</option>
							<option value="11">11</option>
							<option value="12">12</option>
							<option value="13">13</option>
							<option value="14">14</option>
							<option value="15">15</option>
							<option value="16">16</option>
							<option value="17">17</option>
							<option value="18">18</option>
							<option value="19">19</option>
							<option value="20">20</option>
							<option value="21">21</option>
							<option value="22">22</option>
							<option value="23">23</option>
							<option value="24">24</option>
							<option value="25">25</option>
							<option value="26">26</option>
							<option value="27">27</option>
							<option value="28">28</option>
							<option value="29">29</option>
							<option value="30">30</option>
							<option value="31">31</option>
						</select>
						<select name="year" id="year">
							<option value="2022">2022</option>
							<option value="2021">2021</option>
							<option value="2020">2020</option>
							<option value="2019">2019</option>
							<option value="2018">2018</option>
							<option value="2017">2017</option>
							<option value="2016">2016</option>
							<option value="2015">2015</option>
							<option value="2014">2014</option>
							<option value="2013">2013</option>
							<option value="2012">2012</option>
							<option value="2011">2011</option>
							<option value="2010">2010</option>
							<option value="2009">2009</option>
							<option value="2008">2008</option>
							<option value="2007">2007</option>
							<option value="2006">2006</option>
							<option value="2005">2005</option>
							<option value="2004">2004</option>
							<option value="2003">2003</option>
							<option value="2002">2002</option>
							<option value="2001">2001</option>
							<option value="2000">2000</option>
							<option value="1999">1999</option>
							<option value="1998">1998</option>
							<option value="1997">1997</option>
							<option value="1996">1996</option>
							<option value="1995">1995</option>
							<option value="1994">1994</option>
							<option value="1993">1993</option>
							<option value="1992">1992</option>
							<option value="1991">1991</option>
							<option value="1990">1990</option>
							<option value="1989">1989</option>
							<option value="1988">1988</option>
							<option value="1987">1987</option>
							<option value="1986">1986</option>
							<option value="1985">1985</option>
							<option value="1984">1984</option>
							<option value="1983">1983</option>
							<option value="1982">1982</option>
							<option value="1981">1981</option>
							<option value="1980">1980</option>
							<option value="1979">1979</option>
							<option value="1978">1978</option>
							<option value="1977">1977</option>
							<option value="1976">1976</option>
							<option value="1975">1975</option>
							<option value="1974">1974</option>
							<option value="1973">1973</option>
							<option value="1972">1972</option>
							<option value="1971">1971</option>
							<option value="1970">1970</option>
							<option value="1969">1969</option>
							<option value="1968">1968</option>
						</select>
					</div>
					<a href="/Library/SignIn">Already have an account?</a>
					<input type="submit" class="btn" value="SignUp" />
				</form>
			</div>
			<div class="misc">
				<img class="rocketImg" src="./resources/images/rocket.svg" alt="Floating rocket">
			</div>
		</main>
		<script type="text/javascript">
		
			const form = document.getElementById("form");
			const nickname = document.getElementById("nickname");
			const pass1 = document.getElementById("pass1");
			const pass2 = document.getElementById("pass2");
	
			form.addEventListener('submit', (e) => {
	
			    if (nickname.value.length < 8) {
			        nickname.setCustomValidity('The nickname needs to have more than 8 digits');
			        e.preventDefault();
			    }
	
			    if (pass1.value.length < 8 || pass1 == null) {
			        pass1.setCustomValidity('The password needs to have more than 8 digits');
			        e.preventDefault();
			    }else if (pass2.value.length < 8 || pass2 == null) {
			        pass2.setCustomValidity('The password needs to have more than 8 digits');
			        e.preventDefault();
			    }
	
			    if (pass2 !== pass1) {
			        pass2.setCustomValidity('The passwords do not match');
			        e.preventDefault();
			    }
	
			})
		
		</script>
	</body>
	</html>