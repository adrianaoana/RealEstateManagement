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

<title>Real estate management - User settings</title>
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
					<h1 class="page-header">My profile - Settings</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<div class="editProfileContainer">
				<div class="col-md-8">
					<div class="well">
						<ul class="nav nav-tabs" style="margin-bottom: 15px;">
							<li class="active"><a href="#profil" data-toggle="tab">Profile</a></li>
							<li><a href="#parola" data-toggle="tab">Password</a></li>
						</ul>
						<div id="myTabContent" class="tab-content">
							<div class="tab-pane active in" id="profil">
								<form:form name="editUser" modelAttribute="user" id="tab"
									action="${CONTEXT_PATH}/user/settings" method="POST">
									<form:input type="hidden" path="password" />
									<form:input type="hidden" path="role" />
									<div class="row">
										<s:bind path="*">
											<c:if test="${status.error}">
												<div class="alert alert-danger" role="alert">
													<span class="glyphicon glyphicon-exclamation-sign"
														aria-hidden="true"></span> <span class="sr-only">Error:</span>
													Invalid data
												</div>
											</c:if>
											<c:if test="${not empty errorMessage}">
												<div class="alert alert-danger" role="alert">
													<span class="glyphicon glyphicon-exclamation-sign"
														aria-hidden="true"></span> <span class="sr-only">Error:</span>
													${errorMessage}
												</div>
											</c:if>
										</s:bind>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>Email address</label>
											<form:input type="email" path="email" class="form-control"
												readonly="true" required="required" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>First name</label>
											<form:input type="text" path="firstName" class="form-control"
												placeholder="First name" />
											<form:errors path="firstName" class="error" id="redError" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>Last name</label>
											<form:input type="text" path="lastName" class="form-control"
												placeholder="Last name" />
											<form:errors path="lastName" class="error" id="redError" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>Country</label>

											<form:select path="country" id="countrySelect"
												class="form-control" required="required" title="Country">
												<option value="${user.country}" selected>${user.country}</option>
												<c:if test="${user.district != 'Romania'}">
													<option value="Romania">Romania</option>
												</c:if>
												<option value="Germania">Germania</option>
												<option value="Franta">Franta</option>
												<option value="Belgia">Belgia</option>
												<option value="Bulgaria">Bulgaria</option>
												<option value="Olanda">Olanda</option>
												<option value="Spania">Spania</option>
												<option value="Italia">Italia</option>
												<option value="SUA">SUA</option>
												<option value="Marea Britanie">Marea Britanie</option>
												<option value="Danemarca">Danemarca</option>
												<option value="Irlanda">Irlanda</option>
												<option value="Austria">Austria</option>
												<option value="Canada">Canada</option>
												<option value="Suedia">Suedia</option>
												<option value="Ungaria">Ungaria</option>
												<option value="Cehia">Cehia</option>
												<option value="Luxemburg">Luxemburg</option>
												<option value="Polonia">Polonia</option>
												<option value="Grecia">Grecia</option>
												<option value="Slovenia">Slovenia</option>
												<option value="Estonia">Estonia</option>
												<option value="Strainatate">Strainatate</option>
											</form:select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>District</label>
											<form:select path="district" id="districtSelect"
												class="form-control" title="City">
												<c:choose>
													<c:when test="${empty user.district}">
														<option value="">- Select -</option>
													</c:when>
													<c:otherwise>
														<option value="${user.district}">${user.district}</option>
													</c:otherwise>
												</c:choose>
												<option value="BUCURESTI">BUCURESTI</option>
												<option value="Alba">Alba</option>
												<option value="Arad">Arad</option>
												<option value="Arges">Arges</option>
												<option value="Bacau">Bacau</option>
												<option value="Bihor">Bihor</option>
												<option value="Bistrita-Nasaud">Bistrita-Nasaud</option>
												<option value="Botosani">Botosani</option>
												<option value="Brasov">Brasov</option>
												<option value="Braila">Braila</option>
												<option value="Buzau">Buzau</option>
												<option value="Caras Severin">Caras Severin</option>
												<option value="Calarasi">Calarasi</option>
												<option value="Cluj">Cluj</option>
												<option value="Constanta">Constanta</option>
												<option value="Covasna">Covasna</option>
												<option value="Dambovita">Dambovita</option>
												<option value="Dolj">Dolj</option>
												<option value="Galati">Galati</option>
												<option value="Giurgiu">Giurgiu</option>
												<option value="Gorj">Gorj</option>
												<option value=Harghita>Harghita</option>
												<option value="Hunedoara">Hunedoara</option>
												<option value="Ialomita">Ialomita</option>
												<option value="Iasi">Iasi</option>
												<option value="Ilfov">Ilfov</option>
												<option value="Maramures">Maramures</option>
												<option value="Mehedinti">Mehedinti</option>
												<option value="Mures">Mures</option>
												<option value="Neamt">Neamt</option>
												<option value="Olt">Olt</option>
												<option value="Prahova">Prahova</option>
												<option value="Satu Mare">Satu Mare</option>
												<option value="Salaj">Salaj</option>
												<option value="Sibiu">Sibiu</option>
												<option value="Suceava">Suceava</option>
												<option value="Teleorman">Teleorman</option>
												<option value="Timis">Timis</option>
												<option value="Tulcea">Tulcea</option>
												<option value="Vaslui">Vaslui</option>
												<option value="Valcea">Valcea</option>
												<option value="Vrancea">Vrancea</option>
											</form:select>
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>City</label>
											<form:input type="text" path="city" class="form-control"
												placeholder="City" />
											<form:errors path="city" class="error" id="redError" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>Phone</label>
											<form:input type="text" path="phone" class="form-control"
												placeholder="Phone" />
											<form:errors path="phone" class="error" id="redError" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<input type="submit" value="Update"
												class="btn btn-outline btn-primary btn-lg btn-block btn-danger" />
										</div>
									</div>

								</form:form>
							</div>
							<div class="tab-pane fade" id="parola">
								<form id="tab2">
									<div class="row">
										<div id="messageChangePassword"></div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<label>New password</label> <input type="password" value=""
												id="newPassword1" name="newPassword1" class="form-control"
												placeholder="New password" autocomplete="off"
												required="required" />
										</div>
									</div>

									<div class="row">
										<div class="form-group col-sm-12">
											<label>New password - check</label> <input type="password"
												id="newPassword2" name="newPassword2" class="form-control"
												placeholder="New password - check" required="required" />
										</div>
									</div>
									<div class="row">
										<div class="form-group col-sm-12">
											<button id="changePassword" type="button"
												class="btn btn-outline btn-primary btn-lg btn-block btn-danger">Update</button>
										</div>
									</div>
								</form>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
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