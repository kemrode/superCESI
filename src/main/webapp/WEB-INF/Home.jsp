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
                    <form method="post" class="incidentForm" action="./Incident">
                        <%@include file="IncidentForm.jsp"%>
                        <div class="infoBox">
                            <input type="text" name="incidentCity" placeholder="Où se trouve le problème ?">
                            <script type="text/javascript" src="${pageContext.request.contextPath}/scripts/GetUserPositionScript.js"></script>
                        </div>
                        <div class="validateBtn">
                            <input type="submit" name="validateBtn" value="Valider">
                        </div>
                    </form>
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
<%--            <script>--%>
<%--                <k:forEach var="incident" items="${incidentList}" varStatus="loop">--%>
<%--                newIncidentToDisplay(`${incident.latitude}`,`${incident.longitude}`)--%>
<%--                function newIncidentToDisplay(latitude, longitude){--%>
<%--                    console.log(latitude);--%>
<%--                    console.log(longitude);--%>
<%--                    const marker = new mapboxgl.Marker()--%>
<%--                        .setLngLat([latitude,longitude])--%>
<%--                        .addTo(map);--%>
<%--                }--%>
<%--                &lt;%&ndash;                <script>&ndash;%&gt;--%>
<%--                &lt;%&ndash;var incident = `${incident}`;&ndash;%&gt;--%>
<%--                &lt;%&ndash;console.log(`${incident.latitude}`);&ndash;%&gt;--%>
<%--                &lt;%&ndash;const marker = new mapboxgl.Marker()&ndash;%&gt;--%>
<%--                &lt;%&ndash;    .setLngLat([`${incident.latitude}`,`${incident.longitude}`])&ndash;%&gt;--%>
<%--                &lt;%&ndash;    .addTo(map);&ndash;%&gt;--%>
<%--                &lt;%&ndash;                </script>&ndash;%&gt;--%>
<%--                </k:forEach>--%>
<%----%>
<%--            </script>--%>
<%--            <k:forEach var="incident" items="${incidentList}">--%>
<%--&lt;%&ndash;                <script>&ndash;%&gt;--%>
<%--                    &lt;%&ndash;var incident = `${incident}`;&ndash;%&gt;--%>
<%--                    &lt;%&ndash;console.log(`${incident.latitude}`);&ndash;%&gt;--%>
<%--                    &lt;%&ndash;const marker = new mapboxgl.Marker()&ndash;%&gt;--%>
<%--                    &lt;%&ndash;    .setLngLat([`${incident.latitude}`,`${incident.longitude}`])&ndash;%&gt;--%>
<%--                    &lt;%&ndash;    .addTo(map);&ndash;%&gt;--%>
<%--&lt;%&ndash;                </script>&ndash;%&gt;--%>
<%--            </k:forEach>--%>
        </div>
        <div class="SuperCardScrollview">
            <k:forEach items="${list}" var="z">
                <%@include file="superZCard.jsp"%>
            </k:forEach>
        </div>
    </div>
</div>
</body>
</html>