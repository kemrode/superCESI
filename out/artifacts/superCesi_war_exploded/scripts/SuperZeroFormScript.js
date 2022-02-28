let limit = 3;
$('input.incident-single').on('change', function(evt){
    if($(this).siblings(':checked').length >= limit){
        this.checked = false;
    }
});

// $('input[type=checkbox]').change(function(e){
//     if ($('input[type=checkbox]:checked').length > 3) {
//         $(this).prop('checked', false)
//         alert("Vous ne pouvez gérer que trois choses à la fois...");
//     }
// });