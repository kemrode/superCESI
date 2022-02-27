<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<div id="MainForm">
    <form method="post" class="formulaire">
        <div class="infoBox">
            <input type="text" name="superName" placeholder="Votre Super-nom">
        </div>
        <div class="infoBox">
            <input type="number" name="superPhone" placeholder="Votre super-Téléphone" >
        </div>
        <div class="infoBox">
            <input type="text" name="latitude" placeholder="votre latitude">
        </div>
        <div class="infoBox">
            <input type="text" name="longitude" placeholder="votre longitude">
        </div>
        <div id="incidentsBox">
<%--            for each incident inside an incidentsArray make a foreach loop to display the differents incidents--%>
            <div class="incident">
                <div class="incidentCheck">
                    <input type="checkbox" disabled>
                </div>
                <div class="incidentLabel">
                    <label>Centre de vaccination vidoc20</label>
                </div>
            </div>
        </div>
    </form>
</div>
