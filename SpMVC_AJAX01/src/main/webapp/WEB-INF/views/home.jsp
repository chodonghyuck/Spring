<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="UTF-8">
<title>나라 Plus</title>
<link rel="stylesheet" href="<c:url value= '/css/home.css' /> ">

</head>
<body>
	<header class="main-header">
		<h2>나라 Plus</h2>
	</header>

	<section class="content-container">
		<aside class="sidebar">Side-bar</aside>
		<article class="main">

			<div class="page-header">section header</div>
			<div class="content">
				<form action="dept" method="POST">
					<div class="column sub1">

						<button>조회</button>
					</div>
				</form>

				<div class="column sub2">column</div>
			</div>

		</article>
	</section>

	<footer>
		<address>CopyRight &copy; colplayer@naver.com</address>
	</footer>
</body>
</html>