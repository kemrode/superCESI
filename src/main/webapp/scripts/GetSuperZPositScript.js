let button = document.querySelector(".validateBtn");
let formulaire = document.querySelector(".formulaire");
let latitude;
let longitude;
button.addEventListener('click',async (e)=>{
    e.preventDefault();
    GetLocalisationFromCity().then((response) =>{
        let feature = response.features['0'];
        let coord = feature.geometry.coordinates;
        latitude = coord[1];
        longitude = coord[0];
        let inputLat = document.querySelector(".latitude");
        inputLat.value = latitude;
        let inputLong = document.querySelector(".longitude");
        inputLong.value = longitude;
        formulaire.submit();
    }).catch((error)=>{
        console.error(error);
    });
});
async function GetLocalisationFromCity(){
    let city = document.querySelector(".superZCity").value;
    let url = "https://api.mapbox.com/geocoding/v5/mapbox.places/";
    let key = 'pk.eyJ1Ijoia2Vtcm9kZSIsImEiOiJjbDAzbmkycjkwZXB6M25xZGkxNzFtNGFtIn0.H_y4SaibmfnmyxzT9VfOww';
    const call = url + city +".json?access_token=" + key;

    return new Promise((resolve, reject) => {
        xhr = new XMLHttpRequest()
        xhr.open('GET', call);
        xhr.responseType = 'json';
        xhr.onload = () => {
            if (xhr.status >= 200 && xhr.status < 300) {
                resolve(xhr.response);
            } else {
                reject(xhr.statusText);
            }
        };
        xhr.onerror = () => reject(xhr.statusText);
        xhr.send();
    });
}