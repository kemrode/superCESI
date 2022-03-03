<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="k" uri="http://java.sun.com/jsp/jstl/core" %>
<form method="post" class="formulaire" action="./Formulaire">
    <div class="formTitle">
        <h3 class="formTitle__text">Nouveau SuperZ en ville ?</h3>
    </div>
    <div class="infoBox">
        <input type="text" name="superName" placeholder="Votre Super-nom">
    </div>
    <div class="infoBox">
        <input type="tel" name="superPhone" placeholder="Votre super-Téléphone" >
    </div>
    <div class="infoBox">
        <input type="text" name="city" placeholder="quelle ville protégez-vous ?">
    </div>
    <%@include file="IncidentForm.jsp"%>
    <div class="validateBtn">
        <input type="submit" name="validateBtn" value="Valider">
    </div>
</form>
<%--<script src="<k:url value="/scripts/SuperZeroFormScript.js"/>"/>--%>
