<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta nam="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/MainView.css"/>
    <link href='https://api.mapbox.com/mapbox-gl-js/v2.3.1/mapbox-gl.css' rel='stylesheet' />
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/MapBox.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/SuperZForm.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/incidentDeclaration.css"/>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/superZCard.css"/>
    <title>Super0</title>
</head>
<body>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
<div class="MainView">
    <div class="HomeMenuView">
        <div id="menuView">
        </div>
        <div id="formBox">
            <form method="post" class="buttonsChoice" action="./Home">
                <input type="submit" class="selectedButton selectIncident" name="selectedButton" value="incident"/>
                <input type="submit" class="selectedButton selectNewSuperZ" name="selectedButton" value="superZ"/>
            </form>
            <k:choose>
                <k:when test="${selectedButton == 'incident'}">
                    <form method="post" id="incidentForm" action="./Incident">
                        <%@include file="IncidentForm.jsp"%>
                        <div id="locationChoice">
                            <div class="infoBox">
                                <input type="text" name="incidentCity" placeholder="Où se trouve le problème ?">
                            </div>
                            <div class="getPosit">
                                <label>
                                    <input type="checkbox" name="myPosit" value="get">Utiliser mon GPS
                                </label>
                            </div>
                            <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/GetUserPositionScript.js"></script>
                        </div>
                        <div class="validateBtn">
                            <input type="submit" name="validateBtn" value="Valider">
                        </div>
                        <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/NewIncidentTypeScript.js"></script>
                    </form>
                </k:when>
                <k:when test="${selectedButton == 'superZ'}">
                    <%@include file="SuperZeroForm.jsp"%>
                    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/GetSuperZPositScript.js"></script>
                    <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/LimitationCheckBoxScript.js"></script>
                </k:when>
                <k:otherwise>
                    <div class="dead">

                    </div>
                </k:otherwise>
            </k:choose>
        </div>
    </div>
    <div class="HomeMapSuperView">
        <div class="MapBox">
            <%@ include file="mapBox.jsp"%>
        </div>
        <div class="SuperCardScrollview">
            <k:forEach items="${list}" var="z">
                <div class="card">
                    <%@include file="superZCard.jsp"%>
                </div>
            </k:forEach>
        </div>
    </div>
</div>
</body>
</html>