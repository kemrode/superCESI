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
    <title>Super0</title>
</head>
<body>
<div class="MainView">
    <div class="HomeMenuView">
        <div id="menuView">
        </div>
        <div id="formBox">
            <form method="post" class="buttonsChoice">
                <input type="submit" class="selectedButton selectIncident" name="selectedButton" value="incident"/>
                <input type="submit" class="selectedButton selectNewSuperZ" name="selectedButton" value="superZ"/>
            </form>
            <k:choose>
                <k:when test="${selectedButton == 'incident'}">
                    <%@include file="IncidentForm.jsp"%>
                </k:when>
                <k:when test="${selectedButton == 'superZ'}">
                    <%@include file="SuperZeroForm.jsp"%>
                </k:when>
                <k:otherwise></k:otherwise>
            </k:choose>
        </div>
    </div>
    <div class="HomeMapSuperView">
        <div class="MapBox">
            <%@ include file="mapBox.jsp"%>
        </div>
        <div class="SuperCardScrollview">
            <ul>
                <k:forEach var="superZ" items="${list}">
                    <li><k:out value="${ superZ.Name }"/></li>
                </k:forEach>
            </ul>
        </div>
    </div>
</div>
</body>
</html>