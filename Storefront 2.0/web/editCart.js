$(function() {
    $(document).on('click', '.delete', function() {
        $.get('DeleteFromCart', {id: $(this).data('remove')}).then(function(response){
            renderCart(response);
        });
    });
});