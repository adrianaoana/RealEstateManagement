<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>

<html>
<head>
    <title>Offer details</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <c:set var="CONTEXT_PATH" value="<%=request.getContextPath()%>"
    	scope="application" />
    <link href="${CONTEXT_PATH}/resources/css/detail.css"
    	rel="stylesheet" type="text/css">
    	<link href="${CONTEXT_PATH}/resources/css/bootstrap.min.css"
        	rel="stylesheet" type="text/css">
        <link rel="stylesheet" type="text/css"
        	href="${CONTEXT_PATH}/resources/css/jquery-ui.css" />
        <!-- Custom CSS -->
        <link rel="stylesheet" type="text/css"
        	href="${CONTEXT_PATH}/resources/css/style.css">
        <link rel="stylesheet" type="text/css"
        	href="${CONTEXT_PATH}/resources/font-awesome/css/font-awesome.min.css">
</head>
<body>
<%@include file="navigationMenu.jsp"%>
<% com.squad.model.Offer offer = (com.squad.model.Offer) request.getAttribute("offer"); %>
<% if (offer == null) { %>
    <div>Error: Offer with the specified id does not exist</div>
<% } else { %>
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
				<security:authorize access="!hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<a type="button" class="btn btn-labeled btn-danger" href="#"> <span
						class="glyphicon glyphicon-plus"></span> Add offer
					</a>
					<a type="button" class="btn btn-labeled btn-danger" href="#"> <span
						class="glyphicon glyphicon-question-sign"></span> Ask offer
					</a>
				</security:authorize>
				<!-- If logged in, display add page -->
				<security:authorize access="hasAnyRole('ROLE_ADMIN', 'ROLE_USER')">
					<a type="button" class="btn btn-labeled btn-danger"
						href="${CONTEXT_PATH}/add-offer"> <span
						class="glyphicon glyphicon-plus"></span> Add offer
					</a>
					<a type="button" class="btn btn-labeled btn-danger"
						href="${CONTEXT_PATH}/add-offer"> <span
						class="glyphicon glyphicon-question-sign"></span> Ask offer
					</a>
				</security:authorize>
			</div>
			<!-- /.row -->
			<hr />
<section id="containerNew">
    <div id="ofertaNew">
        <div class="ofertaBG clearfix">

            <div id="oferta_leftNew">
                <!--oferta left top-->
                <div class="oferta_leftNewTop clearfix">


                    <div class="oferta_titleNew">
                        <h1><%= offer.getType() + " " + offer.getFeature().getPropertyType() + " " + offer.getPrice() + " eur"   %></h1>
                        <h2><span><%= offer.getAddress().getArea() %></span></h2>

                        <div class="oferta_detailsNew">
                            <strong class="green"><%= offer.getPrice() %> &euro;</strong>
                        </div>
                    </div>
                </div>
                <!--/oferta left top-->
                <div class="ofertad1 ofertad1New">
                    <div class="ofertad1-leftNew clearfix">
                        <h3 class="characteristics">Characteristics</h3>
                        <div class="ocaractNew1">
                            <span class="caractItem"><span class="caractText">Property type:</span> <span
                                    class="number"><%= offer.getFeature().getPropertyType() %></span></span>

                               <span class="caractItem"> <span class="caractText">Division:</span>
                                <span class="number"><%= offer.getFeature().getDivision() %></span></span>

                            <span class="caractItem"><span class="caractText">Comfort:</span> <span
                                    class="number"><%= offer.getFeature().getComfort() %></span></span>

                            <span class="caractItem"><span class="caractText">Floor:</span> <span
                                    class="number"><%= offer.getFeature().getFloor() %></span></span>

                            <span class="caractItem"> <span class="caractText">Usable Surface: </span> <span
                                    class="number"><%= offer.getFeature().getUsableSurface() %></span>
                            </span>

                            <span class="caractItem"><span class="caractText">Number of balconies:</span> <span
                                    class="number"><%= offer.getFeature().getBalconyNo() %></span></span>

                            <span class="caractItem"><span class="caractText">Number of rooms:</span> <span
                                    class="number"><%= offer.getFeature().getRoomNo() %></span></span>

                            <span class="caractItem"><span class="caractText">Number of kitchens:</span> <span
                                    class="number"><%= offer.getFeature().getKitchenNo() %></span></span>

                            <span class="caractItem"><span class="caractText">Includes garage:</span> <span
                                    class="number"><%= offer.getFeature().getGarage() %></span></span>

                            <span class="caractItem"><span class="caractText">Parking spaces:</span> <span
                                    class="number"><%= offer.getFeature().getParkingPlaces() %></span></span>


                        </div>
                        <div class="ocaractNew1 last">

                            <span class="caractItem"><span class="caractText">Street:</span> <span
                                    class="number"><%= offer.getAddress().getStreet() %></span></span>

                            <span class="caractItem"><span class="caractText">Street number:</span> <span
                                    class="number"><%= offer.getAddress().getStreetNo() %></span></span>

                            <span class="caractItem"><span class="caractText">Area:</span> <span
                                    class="number"><%= offer.getAddress().getArea() %></span></span>

                            <span class="caractItem"><span class="caractText">City:</span> <span
                                    class="number"><%= offer.getAddress().getCity() %></span></span>

                            <span class="caractItem"><span class="caractText">District:</span> <span
                                    class="number"><%= offer.getAddress().getDistrict() %></span></span>

                            <span class="caractItem"><span class="caractText">Country:</span> <span
                                    class="number"><%= offer.getAddress().getCountry() %></span></span>

                        </div>

                    </div>


                </div>

                <div class="extra-details">

                    <div class="ofertad1 m7 ofertad1New">
                        <h4>Other details</h4>
                        <p>
                            <%= offer.getDetails() %>
                        </p>
                    </div>

                </div>

                <div class="extra-details">

                    <div class="ofertad1 m7 ofertad1New">
                        <h4>Images</h4>
                        <p>
                        <ul id="slide">
                            <% for (com.squad.model.Image image : offer.getImages()) { %>
                                <li>
                                <% int length = (int) image.getImage().length(); %>
                                <% String url = "data:image/*;base64," + com.google.common.io.BaseEncoding.base64().encode(image.getImage().getBytes(1l, length));%>
                                    <img
                                    src="<%= url%>"
                                    width="600" height="600"
                                    >
                                </li>
                            <% } %>
                        </ul>

                        </p>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>
</div>
</div>
<% } %>
</body>
</html>