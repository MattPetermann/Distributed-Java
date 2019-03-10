$(function() {
    $(document).on('click', '.delete', function() {
        //Call servlet to remove item from cart
        $.get('DeleteFromCart', {id: $(this).data('remove')}).then(function(response){
            renderCart(response);
            animateCart();
        });
    });

    $(document).on('change', '.quantityChange', function() {
        //Verify value is proper or default it
        var val = $(this)[0].value;
        val = val >= 1 ? val : 1;
        val = val % 1 === 0 ? val : Math.floor(val);
        $(this).val(val);

        //Call servlet to update cart
        $.get('EditCart', {id: $(this).data('edit'), value: val}).then(animateCart);
    });
});