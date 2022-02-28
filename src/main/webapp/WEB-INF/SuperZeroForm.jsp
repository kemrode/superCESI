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
        <input type="text" name="latitude" placeholder="votre latitude">
    </div>
    <div class="infoBox">
        <input type="text" name="longitude" placeholder="votre longitude">
    </div>
    <div id="incidentsBox">
        <div class="incident">
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="covid" name="covid" value="covid20">
                <label for="covid">Centre de vaccination vidoc20</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="fire" name="fire" value="fireAlert">
                <label for="fire">Incendies</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="road" name="road" value="roadInjured">
                <label for="road">Accidents routiers</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="river" name="river" value="riverInjured">
                <label for="river">Accidents fluviaux</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="air" name="air" value="airInjured">
                <label for="air">Accidents aériens</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="crumbling" name="crumbling" value="crumblingInjured">
                <label for="crumbling">Eboulements</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="snake" name="snake" value="snakeInvade">
                <label for="snake">Invasions de serpents</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="ET" name="ET" value="ETInvade">
                <label for="ET">Invasions extra-terrestre</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="gas" name="gas" value="gasInjured">
                <label for="gas">Fuite de gaz</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="freedom" name="freedom" value="manifestationFreedom">
                <label for="freedom">Manifestations pour la liberté</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="holdup" name="holdup" value="holdupInjured">
                <label for="holdup">Braquages</label>
            </div>
            <div class="incidentCheck">
                <input class="incident-single" type="checkbox" id="escape" name="escape" value="greatEscape">
                <label for="escape">Evasion</label>
            </div>
        </div>
        <div class="validateBtn">
            <input type="submit" name="validateBtn" value="Valider">
        </div>
    </div>
</form>
<%--<script src="<k:url value="/scripts/SuperZeroFormScript.js"/>"/>--%>
