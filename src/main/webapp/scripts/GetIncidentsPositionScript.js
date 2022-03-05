// CreateInputElement(latitude,"latitude");
newIncidentPoint(latitude, longitude);


function newIncidentPoint(latitude, longitude){
    const marker = new mapboxgl.Marker()
        .setLngLat([`${latitude}`,`${longitude}`])
        .addTo(map);
}

// function CreateInputElement(posit, name){
//     let form = document.querySelector("#map");
//     let inputElement = document.createElement('input');
//     inputElement.setAttribute("type","hidden");
//     inputElement.setAttribute("value",`${posit}`);
//     inputElement.setAttribute("name",`${name}`)
//     form.append(inputElement);
// }