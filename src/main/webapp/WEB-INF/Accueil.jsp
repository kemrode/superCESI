<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta nam="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/Pages/MainView.css"/>
    <title>Super0</title>
</head>
<body>
<div class="MainView">
    <div class="HomeMenuView">
        <p>HomeMenuView</p>
        <!--<a href="./WEB-INF/Accueil.jsp">voir le test</a>-->
    </div>
    <div class="HomeMapSuperView">
        <div class="MapBox">
            <%@include file="mapBox.jsp"%>
        </div>
        <div class="SuperCardScrollview">
            <p>SuperCardScrollview</p>
        </div>
    </div>
</div>

</body>
</html>