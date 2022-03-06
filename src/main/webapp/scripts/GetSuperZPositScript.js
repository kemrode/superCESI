CreateInputLatLng("latitude");
CreateInputLatLng("longitude");
GetLocalisationFromCity();

function GetLocalisationFromCity(){
    let latitude;
    let longitude;
    let city = document.querySelector(".superZCity").innerHTML;
    let url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    let key = 'pk.eyJ1Ijoia2Vtcm9kZSIsImEiOiJjbDAzbmkycjkwZXB6M25xZGkxNzFtNGFtIn0.H_y4SaibmfnmyxzT9VfOww';
    const call = url + city +".json?access_token=" + key;
    let request = new XMLHttpRequest();
    request.open('GET',call);
    request.responseType = 'json';
    request.send();
    request.onload = function(){
        if(request.readyState == XMLHttpRequest.DONE){
            if(request.status == 200){
                let response = request.response;
                let feature = response.features['0'];
                let coord = feature.geometry.coordinates;
                console.log(coord);
                latitude = coord['1'];
                longitude = coord['0'];
                let inputLat = document.querySelector(".LatLng");
                inputLat.setAttribute("value",latitude);
                let inputLong = document.querySelector(".LatLng");
                inputLong.setAttribute("value",longitude);
            }else {
                alert('An error occured when call API.')
            }
        }
        // CreateInputElement(latitude, "latitude");
        // CreateInputElement(longitude, "longitude");
    }
}

function CreateInputElement(posit, name){
    // let form = document.querySelector(".formulaire");
    // let inputElement = document.createElement('input');
    // inputElement.setAttribute("type","hidden");
    // inputElement.setAttribute("value",posit);
    // inputElement.setAttribute("name",name)
    // if(form != null){
    //     form.append(inputElement);
    //     console.log("ok");
    // }
}

function CreateInputLatLng(name){
    let form = document.querySelector(".formulaire");
    let inputElement = document.createElement('input');
    inputElement.setAttribute("type","hidden");
    inputElement.setAttribute("class","LatLng");
    inputElement.setAttribute("name",name);
    form.append(inputElement);
}