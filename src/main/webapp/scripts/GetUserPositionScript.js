let city = document.querySelector(".superZCity");
let url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";

GetLocalisationFromCity();

//1=> fonction pour récupérer la position de l'utilisateur et l'afficher sur la carte
function GetUserPosition(){
    navigator.geolocation.getCurrentPosition(newPosition);
}
//2=> récupérer cette position en créant des éléments de type input hidden dans le formulaire quand on créé un nouvel incident
function GetLocalisationFromCity(){
    const call = url + city.toString() +".json";
    let request = new XMLHttpRequest();
    request.open('GET',call);
    request.responseType = 'json';
    request.send();
    request.onload = function(){
        if(request.readyState == XMLHttpRequest.DONE){
            if(request.status == 200){
                let response = request.response;
                //dessiner un icône sur la carte à cet emplacement

            }else {
                alert('An error occured when call API.')
            }
        }
    }
}
//3=> fonction pour convertir en coordonnées géo la ville du héros pour l'afficher
//4=> communiquer avec l'api de mapbox




