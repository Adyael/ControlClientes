/*$(document).on('change', '#tieneMP', function () {
    
    if($(this).val() == 1){
        
        $('#mp').addProp('required');
        $('.MP').removeClass('d-none');
        $('.NORMAL').addClass('d-none');

    } else if ($(this).val() == 0) {
        $('#mp').removeProp('required');
        $('.MP').addClass('d-none');
    } else {
        $('#mp').removeProp('required');
        $('.MP').addClass('d-none');
        $('.NORMAL').addClass('d-none');
    }
});*/

$(document).ready(function () {
    $('.numero').on('input', function () {
        this.value = this.value.replace(/[^0-9]/g, ''); // Remueve cualquier caracter que no sea número
    });
});
