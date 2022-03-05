
GetLocalisationFromCity();

function GetLocalisationFromCity(){
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
            }else {
                alert('An error occured when call API.')
            }
        }
    }
}




