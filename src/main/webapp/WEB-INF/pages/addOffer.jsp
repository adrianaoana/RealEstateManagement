<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="s" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/security/tags"
           prefix="security" %>
<html dir="ltr" lang="ro-RO">
<head>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta charset="utf-8">
    <c:set var="CONTEXT_PATH" value="<%=request.getContextPath()%>"
           scope="application"/>
    <!-- Bootstrap Core CSS -->
    <link href="${CONTEXT_PATH}/resources/css/bootstrap.min.css"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet" type="text/css"
          href="${CONTEXT_PATH}/resources/css/jquery-ui.css"/>
    <!-- Custom CSS -->
    <link rel="stylesheet" type="text/css"
          href="${CONTEXT_PATH}/resources/css/style.css">
    <link rel="stylesheet" type="text/css"
          href="${CONTEXT_PATH}/resources/font-awesome/css/font-awesome.min.css">


    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <title>Real estate management - Add offer</title>
</head>
<body>
<!-- Navigation -->
<%@include file="navigationMenu.jsp" %>
<!-- Page Content -->
<div style="margin-bottom: 0; min-height: 100%;">
    <div class="container">
        <div>
            <!-- /.row -->
            <hr/>
            <h3 align="center">Add offer</h3>

            <h4>I want to: </h4>
            <form:form action="add-offer" method="post" modelAttribute="myObject" enctype="multipart/form-data">
                <div class="col-lg-2">
                    <form:select class="form-control" path="type">
                        <option>Sell</option>
                        <option>Rent</option>
                    </form:select>
                </div>
                <br>
                <br>
                <label>Price:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" id="price" path="price"/>
                </div>
                <br>
                <br>
                <h4>Placed in:</h4>
                <br>
                <label>Street:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="street"/>
                </div>
                <br>
                <br>
                <label>Street No:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="streetNo"/>
                </div>
                <br>
                <br>
                <label>District:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="district"/>
                </div>
                <br>
                <br>
                <label>Country:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="country"/>
                </div>
                <br>
                <br>
                <label>Area:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="area"/>
                </div>
                <br>
                <br>
                <label>City:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="city"/>
                </div>
                <br>
                <br>
                <h4>Features: </h4>
                <label>Property type:</label>
                <br>
                <div class="col-lg-2">
                    <form:select class="form-control" path="propertyType">
                        <option id="apSelect">Apartament</option>
                        <option id="studio">Studio</option>
                        <option id="houseSelect">House</option>
                        <option id="landSelect">Land</option>
                    </form:select>
                </div>
                <br>
                <br>
                <label>Division:</label>
                <br>
                <div class="col-lg-2">
                    <form:select class="form-control" path="division">
                        <option id="Divided">Divided</option>
                        <option id="Semidivided">Semidivided</option>
                        <option id="Nondivided">Non divided</option>
                        <option id="Circular">Circular</option>
                        <option id="Vagon">Vagon</option>
                    </form:select>
                </div>
                <br>
                <br>
                <label>Comfort:</label>
                <br>
                <div class="col-lg-2">
                    <form:select class="form-control" path="confort">
                        <option id="conf1">Furnished equiped</option>
                        <option id="conf2">Without furniture</option>
                    </form:select>
                </div>
                <br><br>
                <%--<label>Garage:</label>--%>
                <%--<br>--%>
                <%--<div class="col-lg-2">--%>
                <%--<form:select class="form-control" path="garage">--%>
                <%--<option id="conf1">True</option>--%>
                <%--<option id="conf2">False</option>--%>
                <%--</form:select>--%>
                <%--</div>--%>
                <br><br>
                <label>Floor:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="floor"/>
                </div>
                <br><br>
                <label>Usable surface:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="usableSurface"/>
                </div>
                <br>
                <br>
                <label>Room no:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="roomNo"/>
                </div>
                <br><br>
                <label>Bathroom no:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="bathroomNo"/>
                </div>
                <br>
                <br>
                <label>Balcony no:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="balconyNo"/>
                </div>
                <br>
                <br>
                <label>Kitchen no:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="kitchenNo"/>
                </div>
                <br>
                <br>
                <label>Parking places:</label>
                <br>
                <div class="col-lg-2">
                    <form:input type="text" class="form-control" path="parkingPlaces"/>
                </div>
                <br>
                <br>

                <label>Detail:</label>
                <br>
                <div class="col-lg-2">
                    <form:textarea class="form-control" rows="5" path="detail"></form:textarea>
                </div>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <label>Add images:</label> <br> <br>
                <form:input type="file" name="pic" accept="image/*" path="image"/>
                <br><br>
                <button type="submit" class="btn btn-success">Submit</button>
            </form:form>

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
</body>
</html>