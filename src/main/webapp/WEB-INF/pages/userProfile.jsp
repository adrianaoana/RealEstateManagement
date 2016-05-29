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

<title>Real estate management - User profile</title>
</head>
<body>
	<!-- Navigation -->
	<%@include file="navigationMenu.jsp"%>
	<!-- Page Content -->
	<div style="margin-bottom: 0; min-height: 100%;">
		<div class="container">
			<div class="row">
				<div class="col-lg-12">

					<form method="get"
						action="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"
						name="searchForm">
						<div class="input-group">
							<input type="text" class="form-control" name="sch" value="${sch}"
								placeholder="Search for..."> <span
								class="input-group-btn">
								<button class="btn btn-default" type="submit">
									<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
									Search
								</button>
							</span>
						</div>
						<!-- /input-group -->

						<div style="display: inline-flex; padding-top: 1px;">
							<div class="dropdown">
								<select name="ptype" class="form-control" title="Property type">
									<c:choose>
										<c:when test="${empty ptype}">
											<option value="" selected="selected">Property type</option>
										</c:when>
										<c:otherwise>
											<option value="">Property type</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${ptype eq 'House'}">
											<option value="${ptype}" selected="selected">${ptype}</option>
										</c:when>
										<c:otherwise>
											<option value="House">House</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${ptype eq 'Apartment'}">
											<option value="${ptype}" selected="selected">${ptype}</option>
										</c:when>
										<c:otherwise>
											<option value="Apartment">Apartment</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${ptype eq 'Studio'}">
											<option value="${ptype}" selected="selected">${ptype}</option>
										</c:when>
										<c:otherwise>
											<option value="Studio">Studio</option>
										</c:otherwise>
									</c:choose>
									<c:choose>
										<c:when test="${ptype eq 'Land'}">
											<option value="${ptype}" selected="selected">${ptype}</option>
										</c:when>
										<c:otherwise>
											<option value="Land">Land</option>
										</c:otherwise>
									</c:choose>
								</select>
							</div>
							<div class="dropdown">
								<select name="area" class="form-control" title="Areas">
									<option value="" selected="selected">Areas</option>
									<option value="">Centru</option>
									<option value="">Gheorgheni</option>
									<option value="">Manastur</option>
									<option value="">Zorilor</option>
								</select>
							</div>
							<div class="dropdown">
								<select name="room" class="form-control" title="Room number">
									<option value="" selected="selected">Room no</option>
									<option value="">1</option>
									<option value="">2</option>
									<option value="">3</option>
									<option value="">More than 3</option>
								</select>
							</div>
						</div>
					</form>
				</div>
			</div>
			<div align="center" class="row">
				<a type="button" class="btn btn-labeled btn-danger"
					href="${CONTEXT_PATH}/add-offer"> <span
					class="glyphicon glyphicon-plus"></span> Add offer
				</a> <a type="button" class="btn btn-labeled btn-danger"
					href="${CONTEXT_PATH}/add-offer"> <span
					class="glyphicon glyphicon-question-sign"></span> Ask offer
				</a>
			</div>
			<!-- /.row -->
			<hr />
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">My profile</h1>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6 no-pad">
					<div class="user-pad">
						<h3>Welcome, ${user.firstName}&nbsp;${user.lastName}</h3>
						<h4 class="white">
							<i class="fa fa-check-circle-o"></i> ${user.email}
						</h4>
						<h4 class="white">
							${user.phone}
						</h4>
						<a type="button" class="btn btn-labeled btn-danger"
							href="${CONTEXT_PATH}/user/settings"> <span class="btn-label"><i
								class="fa fa-pencil"></i></span>Settings
						</a>
					</div>
				</div>
			</div>
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