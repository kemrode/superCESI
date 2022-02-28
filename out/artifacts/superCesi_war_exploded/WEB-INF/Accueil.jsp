<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge"><meta name="viewport" content="initial-scale=1,maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/MainView.css"/>
<%--    <link href="https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.css" rel="stylesheet">--%>
<%--    <script src="https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.js"></script>--%>
    <title>Super0</title>
</head>
<body>
<div class="MainView">
    <div class="HomeMenuView">
        <p>HomeMenuView</p>
        <a href="./Formulaire">nouveau zéro en ville</a>
        <!--<a href="./WEB-INF/Accueil.jsp">voir le test</a>-->
    </div>
    <div class="HomeMapSuperView">
        <div class="MapBox">
<%--            <%@include file="mapBox.jsp"%>--%>
        </div>
        <div class="SuperCardScrollview">
            <p>SuperCardScrollview</p>
        </div>
    </div>
</div>

</body>
</html>