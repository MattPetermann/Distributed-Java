$(function() {
    $('.quickAdd').on('submit', function(e) {
        //e.preventDefault();
        add($(this), 1);
    });

    $('.fullAdd').on('submit', function(e){
        e.preventDefault();
        add($(this), $(this).serializeArray()[0].value);
        $($(this).data('modal')).modal('hide');
    });

    var add = function(form, qty) {
        var id = form.data('id');
        var cartSpan = $('#cartCount');

        cartSpan.text(parseInt(cartSpan.text()) + parseInt(qty));
        animateCart();
    };

    var animateCart = function() {
        var el = $('#cartLink');
        el.addClass('animated shake');
        el.on('animationend', function() { el.removeClass('animated shake') });
    }
});