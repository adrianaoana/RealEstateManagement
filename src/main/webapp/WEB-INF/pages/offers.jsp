<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<html dir="ltr" lang="ro-RO">
<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta charset="utf-8">
<c:set var="CONTEXT_PATH" value="<%=request.getContextPath()%>"
	scope="application" />
<!-- Bootstrap Core CSS -->
<link href="${CONTEXT_PATH}/resources/css/bootstrap.min.css"
	rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css"
	href="${CONTEXT_PATH}/resources/css/jquery-ui.css" />
<!-- Custom CSS -->
<link rel="stylesheet" type="text/css"
	href="${CONTEXT_PATH}/resources/css/style.css">
<link rel="stylesheet" type="text/css"
	href="${CONTEXT_PATH}/resources/font-awesome/css/font-awesome.min.css">



<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

<title>Real estate management - Offers</title>
</head>
<body>
	<!-- Navigation -->
	<%@include file="navigationMenu.jsp"%>
	<!-- Page Content -->
	<div style="margin-bottom: 0; min-height: 100%;">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">
					<div class="input-group">
						<input type="text" class="form-control"
							placeholder="Search for..."> <span
							class="input-group-btn">
							<button class="btn btn-default" type="button">
								<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
								Search
							</button>
						</span>
					</div>
					<!-- /input-group -->
					<div style="display: inline-flex">
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								Type <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
								<li><a href="#">Apartament</a></li>
								<li><a href="#">House</a></li>
								<li><a href="#">Land</a></li>
							</ul>
						</div>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu2" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								Room no <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu2">
								<li><a href="#">1</a></li>
								<li><a href="#">2</a></li>
								<li><a href="#">3</a></li>
								<li><a href="#">4+</a></li>
							</ul>
						</div>
						<div class="dropdown">
							<button class="btn btn-default dropdown-toggle" type="button"
								id="dropdownMenu3" data-toggle="dropdown" aria-haspopup="true"
								aria-expanded="true">
								Areas <span class="caret"></span>
							</button>
							<ul class="dropdown-menu" aria-labelledby="dropdownMenu3">
								<li><a href="#">Manastur</a></li>
								<li><a href="#">Gheorgheni</a></li>
								<li><a href="#">Centru</a></li>
								<li><a href="#">Zorilor</a></li>
							</ul>
						</div>
					</div>
				</div>
			</div>
			<div align="center" class="row">
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus"></span> Add offer
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-question-sign"></span> Ask offer
				</button>
			</div>
			<!-- /.row -->
			<hr />
			Offers
		</div>
		<!-- /.container -->
	</div>


	<!-- jQuery -->
	<script src="${CONTEXT_PATH}/resources/js/jquery.min.js"></script>
	<script src="${CONTEXT_PATH}/resources/js/jquery.leanModal.min.js"></script>
	<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
	<!-- Bootstrap Core JavaScript -->
	<script src="${CONTEXT_PATH}/resources/js/bootstrap.min.js"></script>
	<script src="${CONTEXT_PATH}/resources/js/myFunctions.js"></script>
</body>
</html>