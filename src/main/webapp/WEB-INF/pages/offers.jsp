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
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-plus"></span> Add offer
				</button>
				<button type="button" class="btn btn-success">
					<span class="glyphicon glyphicon-question-sign"></span> Ask offer
				</button>
			</div>
			<!-- /.row -->
			<hr />
			<div class="row">
				<div class="col-lg-12">
					<form method="get"
						action="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"
						name="filterForm">
						<div class="panel panel-danger">
							<div class="panel-heading">
								<div class="row">
									<div class="col-sm-12">
										Search criterias
										<button type="submit" class="btn btn-default"
											style="float: right;">Search</button>
									</div>
								</div>
							</div>
							<div class="panel-body">
								<div class="row">
									<div class="col-lg-4">
										Type <select name="type" class="form-control"
											id="type_criteria" title="Type">
											<c:choose>
												<c:when test="${empty type}">
													<option value="" selected="selected">All</option>
												</c:when>
												<c:otherwise>
													<option value="">All</option>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${type eq 'Sale'}">
													<option value="${type}" selected="selected">${type}</option>
												</c:when>
												<c:otherwise>
													<option value="Sale">Sale</option>
												</c:otherwise>
											</c:choose>
											<c:choose>
												<c:when test="${type eq 'Rent'}">
													<option value="${type}" selected="selected">${type}</option>
												</c:when>
												<c:otherwise>
													<option value="Rent">Rent</option>
												</c:otherwise>
											</c:choose>
										</select>
									</div>
									<div class="col-lg-4">
										Property Type <select name="ptype" class="form-control"
											id="ptype_criteria" title="Property type">
											<c:choose>
												<c:when test="${empty ptype}">
													<option value="" selected="selected">All</option>
												</c:when>
												<c:otherwise>
													<option value="">All</option>
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
									<div class="col-lg-4">
										Area <select name="area" class="form-control"
											id="area_criteria" title="Area">
											<option value="" selected="selected">All</option>
											<option value="">Centru</option>
											<option value="">Gheorgheni</option>
											<option value="">Manastur</option>
											<option value="">Zorilor</option>
										</select>
									</div>
								</div>
								<div class="row">
									<div class="col-lg-4">
										Room no <select name="room" class="form-control"
											id="room_criteria" title="Room number">
											<option value="" selected="selected">All</option>
											<option value="">1</option>
											<option value="">2</option>
											<option value="">3</option>
											<option value="">More than 3</option>
										</select>
									</div>
									<div class="col-lg-4">
										Price
										<div class="row">
											<div class="col-lg-6">
												<select name="bp" class="form-control" id="bp_criteria"
													title="Begin price">
													<c:choose>
														<c:when test="${empty bp}">
															<option value="" selected="selected">-</option>
														</c:when>
														<c:otherwise>
															<option value="">Indifferent</option>
														</c:otherwise>
													</c:choose>
													<c:forEach begin="0" end="40000" var="i" step="500">
														<c:choose>
															<c:when test="${i eq bp}">
																<option value="${i}" selected="selected">${i}</option>
															</c:when>
															<c:otherwise>
																<option value="${i}">${i}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</div>
											<div class="col-lg-6">
												<select name="lp" class="form-control" id="lp_criteria"
													title="Price limit">
													<c:choose>
														<c:when test="${empty lp}">
															<option value="" selected="selected">-</option>
														</c:when>
														<c:otherwise>
															<option value="">Indifferent</option>
														</c:otherwise>
													</c:choose>
													<c:forEach begin="500" end="90000" var="i" step="500">
														<c:choose>
															<c:when test="${i eq lp}">
																<option value="${i}" selected="selected">${i}</option>
															</c:when>
															<c:otherwise>
																<option value="${i}">${i}</option>
															</c:otherwise>
														</c:choose>
													</c:forEach>
												</select>
											</div>
										</div>
									</div>
								</div>
							</div>
							<div class="panel-footer">
								<c:if test="${not empty sch}">
									<a
										href="${CONTEXT_PATH}/offers?order=${order}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}&sch="><button
											type="button" class="btn btn-outline btn-danger">
											<i class="fa fa-times fa-fw"></i>Quick search: ${sch}
										</button></a>
								</c:if>
								<c:if test="${not empty type}">
									<a
										href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&ptype=${ptype}&bp=${bp}&lp=${lp}&type="><button
											type="button" class="btn btn-outline btn-danger">
											<i class="fa fa-times fa-fw"></i>Type: ${type}
										</button></a>
								</c:if>
								<c:if test="${not empty ptype}">
									<a
										href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&bp=${bp}&lp=${lp}&ptype="><button
											type="button" class="btn btn-outline btn-danger">
											<i class="fa fa-times fa-fw"></i>Property type: ${ptype}
										</button></a>
								</c:if>
								<c:if test="${not empty bp}">
									<a
										href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&lp=${lp}&bp="><button
											type="button" class="btn btn-outline btn-danger">
											<i class="fa fa-times fa-fw"></i>Begin price: ${bp}
										</button></a>
								</c:if>
								<c:if test="${not empty lp}">
									<a
										href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp="><button
											type="button" class="btn btn-outline btn-danger">
											<i class="fa fa-times fa-fw"></i>Limit price: ${lp}
										</button></a>
								</c:if>
								<%-- 	</c:if> --%>
							</div>
						</div>
					</form>
				</div>
			</div>
			<!-- End row -->
			<div class="row">
				<div class="col-lg-4">
					<form method="get"
						action="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"
						name="orderForm">
						<label id="order_label"> <select name="order"
							class="form-control" id="order_criteria"
							onchange="this.form.submit();">
								<c:choose>
									<c:when test="${order eq '0'}">
										<option value="0" selected="selected">Date -
											Descending</option>
									</c:when>
									<c:otherwise>
										<option value="0">Date - Descending</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order eq '1'}">
										<option value="1" selected="selected">Date -
											Ascending</option>
									</c:when>
									<c:otherwise>
										<option value="1">Date - Ascending</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order eq '2'}">
										<option value="2" selected="selected">Price -
											Ascending</option>
									</c:when>
									<c:otherwise>
										<option value="2">Price - Ascending</option>
									</c:otherwise>
								</c:choose>
								<c:choose>
									<c:when test="${order eq '3'}">
										<option value="3" selected="selected">Price -
											Descending</option>
									</c:when>
									<c:otherwise>
										<option value="3">Price - Descending</option>
									</c:otherwise>
								</c:choose>
						</select>
						</label>
					</form>
				</div>
				<div class="col-lg-8">
					<ul id="pagin">
						<c:choose>
							<c:when test="${currentPage != 1}">
								<li title="First page"><a
									href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">
										<i class="fa fa-angle-double-left fa-fw"></i>
								</a></li>
								<li title="Back"><a
									href="${CONTEXT_PATH}/offers/${currentPage - 1}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"><i
										class="fa fa-angle-left fa-fw"></i></a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled" title="First page"><a href=""> <i
										class="fa fa-angle-double-left fa-fw"></i>
								</a></li>
								<li class="disabled" title="Back"><a href=""><i
										class="fa fa-angle-left fa-fw"></i></a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="${begin}" end="${end}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li title="Current page"><a class="current">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li title="Page ${i}"><a
										href="${CONTEXT_PATH}/offers/${i}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${currentPage lt nrOfPages}">
								<li title="Next"><a
									href="${CONTEXT_PATH}/offers/${currentPage + 1}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"><i
										class="fa fa-angle-right fa-fw"></i></a></li>

								<li title="Last page"><a
									href="${CONTEXT_PATH}/offers/${nrOfPages}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">
										<i class="fa fa-angle-double-right fa-fw"></i>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled" title="Next"><a href=""><i
										class="fa fa-angle-right fa-fw"></i></a></li>

								<li class="disabled" title="Last page"><a href=""> <i
										class="fa fa-angle-double-right fa-fw"></i>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			<!-- End row with pagination -->

			<div class="row text-center">
				<div id="offers-listings" style="padding-top: 10px;">
					<c:forEach var="offer" items="${offers}">
						<div class="col-md-3 col-sm-6 hero-feature">
							<div class="thumbnail">
								<c:choose>
									<c:when test="${empty offer.images}">
										<a class="pull-left" href="${CONTEXT_PATH}/detail/${offer.id}">
											<img alt="image" class="img-responsive"
											src="${CONTEXT_PATH}/resources/img/no-image.jpg">
										</a>
									</c:when>
									<c:otherwise>
										<a class="pull-left" href="${CONTEXT_PATH}/detail/${offer.id}">
											<img alt="image"
											onerror="this.src='${CONTEXT_PATH}/resources/img/no-image.jpg'"
											class="img-responsive" src="${offer.images[0].image}">
										</a>
									</c:otherwise>
								</c:choose>
								<div class="caption">
									<h3>${offer.price} €</h3>
									<p>${offer.feature.propertyType}</p>
									<p>
										<a href="${CONTEXT_PATH}/detail/${offer.id}"
											class="btn btn-danger">More Info</a>
									</p>
								</div>
							</div>
						</div>
						<!-- End col -->
					</c:forEach>
				</div>
				<!-- /.car listings -->
			</div>


			<div class="row">
				<div class="col-lg-12">
					<ul id="pagin">
						<c:choose>
							<c:when test="${currentPage != 1}">
								<li title="First page"><a
									href="${CONTEXT_PATH}/offers?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">
										<i class="fa fa-angle-double-left fa-fw"></i>
								</a></li>
								<li title="Back"><a
									href="${CONTEXT_PATH}/offers/${currentPage - 1}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"><i
										class="fa fa-angle-left fa-fw"></i></a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled" title="First page"><a href=""> <i
										class="fa fa-angle-double-left fa-fw"></i>
								</a></li>
								<li class="disabled" title="Back"><a href=""><i
										class="fa fa-angle-left fa-fw"></i></a></li>
							</c:otherwise>
						</c:choose>
						<c:forEach begin="${begin}" end="${end}" var="i">
							<c:choose>
								<c:when test="${currentPage eq i}">
									<li title="Current page"><a class="current">${i}</a></li>
								</c:when>
								<c:otherwise>
									<li title="Page ${i}"><a
										href="${CONTEXT_PATH}/offers/${i}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">${i}</a></li>
								</c:otherwise>
							</c:choose>
						</c:forEach>

						<c:choose>
							<c:when test="${currentPage lt nrOfPages}">
								<li title="Next"><a
									href="${CONTEXT_PATH}/offers/${currentPage + 1}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}"><i
										class="fa fa-angle-right fa-fw"></i></a></li>

								<li title="Last page"><a
									href="${CONTEXT_PATH}/offers/${nrOfPages}?order=${order}&sch=${sch}&type=${type}&ptype=${ptype}&bp=${bp}&lp=${lp}">
										<i class="fa fa-angle-double-right fa-fw"></i>
								</a></li>
							</c:when>
							<c:otherwise>
								<li class="disabled" title="Next"><a href=""><i
										class="fa fa-angle-right fa-fw"></i></a></li>

								<li class="disabled" title="Last page"><a href=""> <i
										class="fa fa-angle-double-right fa-fw"></i>
								</a></li>
							</c:otherwise>
						</c:choose>
					</ul>
				</div>
			</div>
			<!-- End row with pagination -->
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