<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="hu">
<head>
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1.0"/>
  <title>Starter Template - Materialize</title>

  <!-- CSS  -->
  <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
  <link href="resources/css/materialize.css" type="text/css" rel="stylesheet" media="screen,projection"/>
  <link href="resources/css/style.css" type="text/css" rel="stylesheet" media="screen,projection"/>
</head>
<body>
  <nav class="light-green darken-2" role="navigation">
    <div class="nav-wrapper container"><a id="logo-container" href="#" class="brand-logo">Logo</a>
      <ul class="right hide-on-med-and-down">
      	<sec:authorize access="isAnonymous()">
      		<li><a href="#reg_modal">Regisztráció</a></li>
        	<li><a href="#login_modal">Bejelentkezés</a></li>
      	</sec:authorize>
        <li><a href="#">Versenyek</a></li>
        <li><a href="#">Keresés</a></li>
        <li><a href="#">GYIK</a></li>
        <sec:authorize access="isAuthenticated()">
        	<li><a href="logout">Kijelentkezés</a></li>
        </sec:authorize>
      </ul>

      <ul id="nav-mobile" class="side-nav">
        <li><a href="#">Navbar Link</a></li>
      </ul>
      <a href="#" data-activates="nav-mobile" class="button-collapse"><i class="material-icons">menu</i></a>
    </div>
  </nav>
  <div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center green-text">Break Down ${loggedIn}</h1>
      <div class="row center">
      	<h5 class="header col s12 light">Ahol ha break versenyt keresel, találni is fogsz!</h5>
      </div>
      <div class="row center">
        <a href="http://materializecss.com/getting-started.html" id="download-button" class="btn-large waves-effect waves-light green">Versenyek</a>
      </div>
      <br><br>

    </div>
  </div>


  <div class="container">
    <div class="section">

      <!--   Icon Section   -->
      <div class="row">
        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-green-text"><i class="material-icons">flash_on</i></h2>
            <h5 class="center">Speeds up development</h5>

            <p class="light">We did most of the heavy lifting for you to provide a default stylings that incorporate our custom components. Additionally, we refined animations and transitions to provide a smoother experience for developers.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-green-text"><i class="material-icons">group</i></h2>
            <h5 class="center">User Experience Focused</h5>

            <p class="light">By utilizing elements and principles of Material Design, we were able to create a framework that incorporates components and animations that provide more feedback to users. Additionally, a single underlying responsive system across all platforms allow for a more unified user experience.</p>
          </div>
        </div>

        <div class="col s12 m4">
          <div class="icon-block">
            <h2 class="center light-green-text"><i class="material-icons">settings</i></h2>
            <h5 class="center">Easy to work with</h5>

            <p class="light">We have provided detailed documentation as well as specific code examples to help new users get started. We are also always open to feedback and can answer any questions a user may have about Materialize.</p>
          </div>
        </div>
      </div>

    </div>
    <br><br>

    <div class="section">

    </div>
  </div>

  <footer class="page-footer orange">
    <div class="container">
      <div class="row">
        <div class="col l6 s12">
          <h5 class="white-text">Company Bio</h5>
          <p class="grey-text text-lighten-4">We are a team of college students working on this project like it's our full time job. Any amount would help support and continue development on this project and is greatly appreciated.</p>


        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Settings</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
        <div class="col l3 s12">
          <h5 class="white-text">Connect</h5>
          <ul>
            <li><a class="white-text" href="#!">Link 1</a></li>
            <li><a class="white-text" href="#!">Link 2</a></li>
            <li><a class="white-text" href="#!">Link 3</a></li>
            <li><a class="white-text" href="#!">Link 4</a></li>
          </ul>
        </div>
      </div>
    </div>
    <div class="footer-copyright">
      <div class="container">
      Made by <a class="orange-text text-lighten-3" href="http://materializecss.com">Materialize</a>
      </div>
    </div>
  </footer>
  
  <div id="reg_modal" class="modal modal-fixed-footer">
    <div class="modal-content">
      <h4>Regisztráció</h4>
	  	<form action="reg" method="POST">
	    	<div class="row">
	      		<div class="input-field col s12">
	      			<i class="material-icons prefix">account_circle</i>
	          		<input id="name" type="text" class="validate" name="name">
	          		<label for="name">Név</label>
	        	</div>
	        	<div class="input-field col s12">
	        		<i class="material-icons prefix">album</i>
	          		<input id="breaker_name" type="text" class="validate" name="breaker_name">
	          		<label for="breaker_name">Bboy/girl név</label>
	        	</div>
	        	<div class="input-field col s6">
	        		<i class="material-icons prefix">vpn_key</i>
	          		<input id="password" type="password" class="validate" name="password">
	          		<label for="password">Jelszó</label>
	        	</div>
	        	<div class="input-field col s6">
	          		<input id="password_a" type="password" class="validate" name="password_a">
	          		<label for="password_a">Jelszó újra</label>
	        	</div>
	        	<div class="input-field col s12">
	        		<i class="material-icons prefix">perm_contact_calendar</i>
	        		<input placeholder="" type="date" class="datepicker" id="birthday" name="birthday">
	        		<label class="active" for=birthday>Születési idő</label>
	        	</div>
	        	<div class="input-field col s12">
	        		<i class="material-icons prefix">perm_identity</i>
				    <select id="gender" name="gender">
				      <option value="" disabled selected>Válasszon</option>
				      <option value="1">Férfi</option>
				      <option value="2">Nő</option>
				    </select>
				    <label>Nem</label>
				</div>
				<button class="btn waves-effect waves-light" type="submit" name="action">Regisztrálok
    				<i class="material-icons right">send</i>
  				</button>
	        </div>
	      </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Mégse</a>
    </div>
  </div>

<div id="login_modal" class="modal">
    <div class="modal-content">
      <h4>Regisztráció</h4>
	  	<form action="login" method="POST">
	    	<div class="row">
	        	<div class="input-field col s12">
	        		<i class="material-icons prefix">album</i>
	          		<input id="username" type="text" class="validate" name="username">
	          		<label for="username">Bboy/girl név</label>
	        	</div>
	        	<div class="input-field col s12">
	        		<i class="material-icons prefix">vpn_key</i>
	          		<input id="password" type="password" class="validate" name="password">
	          		<label for="password">Jelszó</label>
	        	</div>
				<button class="btn waves-effect waves-light" type="submit" name="action">Bejelentkezés
    				<i class="material-icons right">lock_open</i>
  				</button>
	        </div>
	      </form>
    </div>
    <div class="modal-footer">
      <a href="#!" class=" modal-action modal-close waves-effect waves-green btn-flat">Mégse</a>
    </div>
  </div>

  <!--  Scripts-->
  <script src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
  <script src="resources/js/materialize.js"></script>
  <script src="resources/js/init.js"></script>

  </body>
</html>
