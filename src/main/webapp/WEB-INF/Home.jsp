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
    <title>Super0</title>
</head>
<body>
<div class="MainView">
    <div class="HomeMenuView">
        <div id="menuView">

        </div>
        <div id="formBox">
            <form method="post" class="buttonsChoice">
                <input type="submit" class="selectedButton selectIncident" name="selectedButton" value="incident">
                </input>
                <input type="submit" class="selectedButton selectNewSuperZ" name="selectedButton" value="superZ">
                </input>
            </form>
            <k:choose>
                <k:when test="${selectedButton == 'incident'}">
                    <p>Tous des cons</p>
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
            <p>SuperCardScrollview</p>
        </div>
    </div>
</div>
</body>
</html>