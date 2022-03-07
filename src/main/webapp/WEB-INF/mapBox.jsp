<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<script src="https://api.mapbox.com/mapbox-gl-js/v2.7.0/mapbox-gl.js"></script>
<div id="map"></div>
<script>
    mapboxgl.accessToken = 'pk.eyJ1Ijoia2Vtcm9kZSIsImEiOiJjbDAzbmkycjkwZXB6M25xZGkxNzFtNGFtIn0.H_y4SaibmfnmyxzT9VfOww';
    const map = new mapboxgl.Map({
        container: 'map',
        style: 'mapbox://styles/mapbox/streets-v11',
        center: [1.1025, 49.44306],
        zoom: 3
    });
    let finalSuperZList = [];
    <k:forEach var="incident" items="${incidentList}" varStatus="loop">
        var positMarker = placeMarker(`${incident.longitude}`,`${incident.latitude}`)
    </k:forEach>

    <k:forEach var="superZ" items="${listSuperZ}" varStatus="loop">
        CompareDistance(`${superZ.latitude}`,`${superZ.longitude}`,`${newIncident.latitude}`, `${newIncident.longitude}`,`${superZ}`);
    </k:forEach>

    function placeMarker(latitude, longitude){
        const marker = new mapboxgl.Marker({
            color: "#de075e",
        }).setLngLat([latitude,longitude]).addTo(map);
    }
    //function to compare the LongLat of a superZ to LongLat of incident
    function CompareDistance(superZLat, superZLong, incidentLat,incidentLong,superZ){
        let superZCoord = new mapboxgl.LngLat(superZLong,superZLat);
        let incidentCoord = new mapboxgl.LngLat(incidentLong, incidentLat);
        let meterDistance = superZCoord.distanceTo(incidentCoord);
        console.log(meterDistance);
        let distance = meterDistance / 1000;
        console.log(distance);
        if(distance <= 50){
            console.log(distance);
            finalSuperZList.push(superZ);
            DrawingCardView(superZ);
        }
        $.post("Home.jsp",finalSuperZList);
    }

    function DrawingCardView(superZ){
        let scrollView = document.querySelector(".SuperCardScrollview");
        console.log(scrollView);
        document.querySelector(".SuperCardScrollview").append(`<div class="cardView">
    <div class="topView">
        <div class="nameLb">
            <p>${superZ.name}</p>
        </div>
        <div class="pictureBox">

        </div>
    </div>
    <div class="businessBox">
        <div class="placeOfWork">
            <p class="superZCity">${superZ.city}</p>
        </div>
        <div class="quotelb">
            <p class="superZCity">${superZ.quote}</p>
        </div>
        <div class="skillBox">
            <p>${superZ.businessIncidents}</p>
        </div>
    </div>
</div>`);
    }
</script>
