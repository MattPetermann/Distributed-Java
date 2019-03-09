$(function() {
    //Quick add adds one of the selected item to cart
    $('.quickAdd').on('submit', function(e) {
        e.preventDefault();
        add($(this), 1);
    });

    //Full add adds a specified number of the selected item to cart
    $('.fullAdd').on('submit', function(e){
        e.preventDefault();
        add($(this), $(this).serializeArray()[0].value);
        $($(this).data('modal')).modal('hide');
    });

    //Presentation layer changes and proxy to servlet
    var add = function(form, qty) {
        var id = form.data('id');
        var cartSpan = $('#cartCount');

        cartSpan.text(parseInt(cartSpan.text()) + parseInt(qty));
        animateCart();

        $.get("AddToCart", {productId: id, quantity: qty}).done(function(response){

        });
    };

    //Animate the cart icon
    var animateCart = function() {
        var el = $('#cartLink');
        el.addClass('animated shake');
        el.on('animationend', function() { el.removeClass('animated shake') });
    }
});