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
        let superZLat =`${superZ.latitude}`;
        let superZLongitude = `${superZ.longitude}`;
        GetSuperZLocalization("${superZ.city}")
        CompareDistance(superZLat,superZLongitude,`${newIncident.latitude}`, `${newIncident.longitude}`,`${superZ}`);
    </k:forEach>

    function placeMarker(latitude, longitude){
        const marker = new mapboxgl.Marker({
            color: "#de075e",
        }).setLngLat([latitude,longitude]).addTo(map);
    }

    //function to bring back the Long and Lat of a superZ
    function GetSuperZLocalization(city){
        let url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
        let key = 'pk.eyJ1Ijoia2Vtcm9kZSIsImEiOiJjbDAzbmkycjkwZXB6M25xZGkxNzFtNGFtIn0.H_y4SaibmfnmyxzT9VfOww';
        const call = url + city +".json?access_token=" + key;
        let request = new XMLHttpRequest();
        request.open('GET',call);
        request.responseType = 'json';
        request.send();
        request.onload = function(){
            if(request.readyState === XMLHttpRequest.DONE){
                if(request.status == 200){
                    let response = request.response;
                    let coord = response.features['0'].geometry.coordinates;
                    superZLat = coord[1];
                    superZLongitude = coord[0];
                }else {
                    alert('An error occured during API call.')
                }
            }
        }
    }
    //function to compare the LongLat of a superZ to LongLat of incident
    function CompareDistance(superZLat, superZLong, incidentLat,incidentLong,superZ){
        let superZCoord = new mapboxgl.LngLat(superZLong,superZLat);
        let incidentCoord = new mapboxgl.LngLat(incidentLong, incidentLat);
        let meterDistance = superZCoord.distanceTo(incidentCoord);
        let distance = meterDistance/1000;
        console.log(distance);
        if(distance <= 50){
            console.log(distance);
            finalSuperZList.push(superZ);
            let test = document.querySelectorAll('div[class$="cardView"]');
            let scrollView = document.querySelector(".SuperCardScrollview");
            document.querySelector(".SuperCardScrollview").appendChild(test);
            // DrawCardView(superZ);
        }
    }

    function DrawCardView(superZ){
        let cardScrollView = document.querySelector(".SuperCardScrollview");

        let cardView = document.createElement("div");
        cardView.setAttribute("class","cardView");

        let topView = document.createElement("div");
        topView.setAttribute("class","topView");
        let nameLb = document.createElement("div");
        nameLb.setAttribute("class","nameLb");
        let p = document.createElement("p");
        p.textContent += `${superZ.name}`;
        nameLb.appendChild(p);
        let pictureBox = document.createElement("div");
        pictureBox.setAttribute("class","pictureBox");
        topView.appendChild(pictureBox);
        cardView.appendChild(topView);

        let businessBox = document.createElement("div");
        businessBox.setAttribute("class","businessBox");

        let placeOfWork = document.createElement("div");
        placeOfWork.setAttribute("class","placeOfWork");
        let pp = document.createElement("p");
        pp.setAttribute("class","superZCity");
        pp.textContent += `${superZ.city}`;
        placeOfWork.appendChild(pp);

        businessBox.appendChild(placeOfWork);

        let quotelb = document.createElement("div");
        quotelb.setAttribute("class","quotelb");
        let quoteP = document.createElement("p");
        quoteP.setAttribute("class","superZCity");
        quoteP.textContent += `${superZ.quote}`;
        quotelb.appendChild(quoteP);

        businessBox.appendChild(quotelb);

        let skillBox = document.createElement("div");
        skillBox.setAttribute("class","skillBox");
        let skillP = document.createElement("p");
        skillP.textContent += `${superZ.businessIncidents}`;
        skillBox.appendChild(skillP);

        businessBox.appendChild(skillBox);
        cardView.appendChild(businessBox);
        cardScrollView.appendChild(cardView);

    }
</script>
