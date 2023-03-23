<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page errorPage="../error.jsp" isErrorPage="false" %>
<!-- Bootstrap tag - allows us to use bootstrop -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/css/bootstrap.min.css"
      integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">


<t:pagetemplate>

    <jsp:attribute name="header">
         Velkommen ${sessionScope.user.username}

    </jsp:attribute>

    <jsp:body>
        <div class="container">

            <c:if test="${sessionScope.user == null}">
                <p>You are not logged in yet. You can do it here: <a
                        href="../login.jsp">Login</a></p>
            </c:if>

            <br><br><br><br><br><br><br><br>

            <!-- tværgående rækker hen over siden -->
            <div class="row">
                <!-- sidens kolonner. 6 angiver at kolonnen skal fylde 6 ud af 12 felter -->
                <div class="col-6">
                    <h5>Kunder</h5>
                    <div class="dropdown">
                        <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Kundefunktioner
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Indsæt beløb hos kunde</a>
                            <style type=text/css>
                                div.dropdown-menu {
                                    background-color: red;
                                }
                            </style>
                        </div>
                    </div>
                </div>
                <div class="col-6">
                    <h5>Ordre</h5>
                    <div class="dropdown">
                        <button class="btn btn-secondary btn-lg dropdown-toggle" type="button" id="dropdownMenuButton1"
                                data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Ordre
                        </button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item" href="#">Se alle ordre</a>
                        </div>
                    </div>
                </div>
            </div>

            <!-- bootstrap JS tags -->
            <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js"
                    integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n"
                    crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
                    integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo"
                    crossorigin="anonymous"></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.4.1/dist/js/bootstrap.min.js"
                    integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6"
                    crossorigin="anonymous"></script>

        </div>

    </jsp:body>

</t:pagetemplate>