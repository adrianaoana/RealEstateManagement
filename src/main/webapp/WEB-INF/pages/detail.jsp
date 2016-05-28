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
    <title>$title</title>
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
<section id="containerNew">
    <div id="ofertaNew">
        <div class="ofertaBG clearfix">

            <div id="oferta_leftNew">
                <!--oferta left top-->
                <div class="oferta_leftNewTop clearfix">


                    <div class="oferta_titleNew">
                        <h1><%= offer.getType() %></h1>
                        <h2><span></span></h2>

                        <div class="oferta_detailsNew">
                            <strong class="green">$price &euro;</strong>
                        </div>

                    </div>
                </div>
                <!--/oferta left top-->
                <div class="ofertad1 ofertad1New">
                    <div class="ofertad1-leftNew clearfix">
                        <h3 class="characteristics">Characteristics</h3>
                        <div class="ocaractNew1">
                            <span class="caractItem"><span class="caractText">Property type:</span> <span
                                    class="number">$tipProp</span></span>

                               <span class="caractItem"> <span class="caractText">Division:</span>
                                <span class="number">$division</span></span>

                            <span class="caractItem"><span class="caractText">Comfort:</span> <span
                                    class="number">$comfort</span></span>

                            <span class="caractItem"><span class="caractText">Floor:</span> <span
                                    class="number">$floor</span></span>

                            <span class="caractItem"> <span class="caractText">Usable Surface: </span> <span
                                    class="number">$surface</span>
                            </span>

                            <span class="caractItem"><span class="caractText">Number of balconies:</span> <span
                                    class="number">$balconies</span></span>

                            <span class="caractItem"><span class="caractText">Number of rooms:</span> <span
                                    class="number">$rooms</span></span>

                            <span class="caractItem"><span class="caractText">Number of kitchens:</span> <span
                                    class="number">$kitchens</span></span>

                            <span class="caractItem"><span class="caractText">Number of garages:</span> <span
                                    class="number">$garages</span></span>

                            <span class="caractItem"><span class="caractText">Parking spaces:</span> <span
                                    class="number">$parkingspaces</span></span>


                        </div>
                        <div class="ocaractNew1 last">

                            <span class="caractItem"><span class="caractText">Street:</span> <span
                                    class="number">$street</span></span>

                            <span class="caractItem"><span class="caractText">Street number:</span> <span
                                    class="number">$streetNo</span></span>

                            <span class="caractItem"><span class="caractText">Area:</span> <span
                                    class="number">$area</span></span>

                            <span class="caractItem"><span class="caractText">City:</span> <span
                                    class="number">$city</span></span>

                            <span class="caractItem"><span class="caractText">District:</span> <span
                                    class="number">$district</span></span>

                            <span class="caractItem"><span class="caractText">Country:</span> <span
                                    class="number">$country</span></span>

                        </div>

                    </div>


                </div>

                <div class="extra-details">

                    <div class="ofertad1 m7 ofertad1New">
                        <h4>Other details</h4>
                        <p>
                            $details
                        </p>
                    </div>

                </div>

                <div class="extra-details">

                    <div class="ofertad1 m7 ofertad1New">
                        <h4>Images</h4>
                        <p>
                        <ul id="slide">

                            <li>
                                <a href="upload/oferte/327x327/vanzari-apartamente-cluj-buna-ziua-809834.jpg"
                                   rel="1" onclick="javascript:bigImg(this);return false;"
                                   class="pic"><img
                                        src="upload/oferte/131x131/vanzari-apartamente-cluj-buna-ziua-809834.jpg"
                                        width="600" height="600"
                                        alt="Thumbnail 1: De vanzare apartament 3 camere, 81 mp, parcare, zona strazii Buna Ziua, Cluj-Napoca,  Buna Ziua"/></a>
                            </li>
                            <li>
                                <a href="upload/oferte/327x327/vanzari-apartamente-cluj-buna-ziua-526243.jpg"
                                   rel="1" onclick="javascript:bigImg(this);return false;"
                                   class="pic"><img
                                        src="upload/oferte/131x131/vanzari-apartamente-cluj-buna-ziua-526243.jpg"
                                        width="600" height="600"
                                        alt="Thumbnail 2: De vanzare apartament 3 camere, 81 mp, parcare, zona strazii Buna Ziua, Cluj-Napoca,  Buna Ziua"/></a>
                            </li>
                        </ul>

                        </p>
                    </div>

                </div>
            </div>
        </div>
    </div>
</section>


</section>
<!-- /wrapper -->
</body>
</html>