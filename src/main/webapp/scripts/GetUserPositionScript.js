GetUserPosition();

function GetUserPosition(){
    navigator.geolocation.getCurrentPosition(success);
}
//Success function Posit
function success(pos){
    var coord = pos.coords;
    CreateInputElement(`${coord.latitude}`,"latitude");
    CreateInputElement(`${coord.longitude}`,"longitude");
}

function CreateInputElement(posit, name){
    let form = document.querySelector(".infoBox");
    let inputElement = document.createElement('input');
    inputElement.setAttribute("type","hidden");
    inputElement.setAttribute("value",`${posit}`);
    inputElement.setAttribute("name",`${name}`)
    form.append(inputElement);
}




