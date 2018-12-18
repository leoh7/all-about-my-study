<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		body {
			text=align : center;
		}
		.header, .footer, .article, .aside, .section{
			border : 1px black solid;
			margin : 10px;
			float : left;
		}
		.header{
			width : 500px;
			height : 100px;
		}
		.footer {
			width : 500px;
			height : 100px;
			clear : left;
			
		}
		.aside {
			width : 100px;
			height : 300px;
			clear : left;
		}
		.article{
			width : 370px;
		}
		.section{
			width : 350px;
			height : 80px;
			margin : 5px;
		}
		
		
	</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<!-- 
	<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
	</nav>

 -->
 	<div class="header">header</div>
	<div class="aside">aside</div>
	<div class="article">
		article
		<div class="section">section1</div>
		<div class="section">section2</div>
		<div class="section">section3</div>
		<div class="section">section4</div>
		<div class="section">section5</div>
	</div>
	<div class="footer">footer</div>
	
	
 </body>
</html> --%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	
	<style type="text/css">
		body {
			text=align : center;
		}
		header, footer, article, aside, section{
			border : 1px black solid;
			margin : 10px;
			float : left;
		}
		header{
			width : 500px;
			height : 100px;
		}
		footer {
			width : 500px;
			height : 100px;
			clear : left;
			
		}
		aside {
			width : 100px;
			height : 300px;
			clear : left;
		}
		section{
			width : 350px;
			height : 700px;
			margin : 5px;
		}
		article{
			width : 370px;
		}
		.affix {
		    top: 0;
		    width: 100%;
		    -webkit-transition: all .5s ease-in-out;
		    transition: all .5s ease-in-out;
		    background-color: #F44336;
		    border-color: #F44336;
		}
		
		.affix a {
		    color: #fff !important;
		    padding: 15px !important;
		    -webkit-transition: all .5s ease-in-out;
		    transition: all .5s ease-in-out;
		}
		
		.affix-top a {
		    padding: 25px !important;
		}
		
		
	</style>
</head>
<body data-spy="scroll" data-target=".navbar" data-offset="50">
<!-- 
	<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
	</nav>

 -->
 	<nav class="navbar navbar-inverse" data-spy="affix" data-offset-top="197">
 	nav
	</nav>
	<aside>aside</aside>
	<article>
		article
		<section>section1</section>
		<section>section2</section>
		<section>section3</section>
		<section>section4</section>
		<section>section5</section>
	</article>
	<footer>footer</footer>
	
	
 </body>
</html>